package ru.itis.dao;

import ru.itis.models.Owners;
import ru.itis.utils.PasswordCache;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Span on 23.10.2016.
 */
public class OwnerDaoImpl implements OwnerDao {
    private Connection connection;
//    Owners owner;

    //language=SQL
    private static final String SQL_GET_OWNER = "SELECT * FROM owners WHERE user_id = ?";
    //language=SQL
    private static final String SQL_GET_ALL_OWNER = "SELECT * FROM owners";
    //language=SQL
    private static final String SQL_UPDATE_OWNER = "UPDATE owners SET user_login = ?, " +
            "user_password = ?, fio = ? WHERE user_id = ?";
    //language=SQL
    private static final String SQL_DELETE_OWNER = "DELETE FROM owners WHERE user_id = ?";
    //language=SQL
    private static final String SQL_ADD_OWNER = "INSERT INTO owners (user_login, user_password, fio) VALUES (?, ?, ?)";
    //language=SQL
    private static final String SQL_SET_TOKEN = "UPDATE owners SET token = ? WHERE user_id = ?";

    public OwnerDaoImpl(DataSource dataSource){
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setToken(Owners owner){
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_SET_TOKEN);

            statement.setInt(2, owner.getUserId());
            statement.setString(1, owner.getToken());
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Owners getOwner(int userId) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_GET_OWNER);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();
            result.next();
            return new Owners(result.getInt("user_id"), result.getString("user_login"),
                    result.getString("user_password"), result.getString("fio"), result.getString("token"));

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Owners> getAllOwners() {
        List<Owners> list = new ArrayList<Owners>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_OWNER);

            ResultSet result = statement.executeQuery();
//            result.next();
            while (result.next()) {
                list.add(new Owners(result.getInt("user_id"), result.getString("user_login"),
                        result.getString("user_password"), result.getString("fio"), result.getString("token")));
            }

            return list;

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void addOwner(Owners owner) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_ADD_OWNER);

            String ownerPassword = PasswordCache.getCache(owner.getUserPassword()); //шифрование пароля)

            statement.setString(1, owner.getUserLogin());
            statement.setString(2, ownerPassword);
            statement.setString(3, owner.getUserFio());
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public void updateOwner(Owners owner) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_OWNER);

            String ownerPassword = PasswordCache.getCache(owner.getUserPassword()); //шифрование пароля)

            statement.setInt(4, owner.getUserId());
            statement.setString(1, owner.getUserLogin());
            statement.setString(2, ownerPassword);
            statement.setString(3, owner.getUserFio());
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void deleteOwner(int userId) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_OWNER);
            statement.setInt(1, userId);
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
