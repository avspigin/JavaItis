package ru.itis.dao;

import ru.itis.models.JdbcConnection;
import ru.itis.models.Owners;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class OwnersDaoJdbcImpl implements OwnersDao {


    // language=SQL
    private static final String SQL_SELECT_FROM_DB = "SELECT * FROM owners WHERE owner_id = ?";
    // language=SQL
    private static final String SQL_SELECT_ALL_FROM_DB = "SELECT * FROM owners";
    // language=SQL
    private static final String SQL_DELETE_FROM_DB = "DELETE FROM owners WHERE owner_id = ?";
    // language=SQL
    private static final String SQL_UPDATE_DB = "UPDATE owners SET fio = ?, age = ?, city = ? WHERE owner_id = ?";
    // language=SQL
    private static final String SQL_ADD_TO_DB = "INSERT INTO owners (fio, age, city) VALUES (?, ?, ?);";


    public Owners find(int id) {

        try {
            PreparedStatement statement = JdbcConnection.getInstance().getConnection().prepareStatement(SQL_SELECT_FROM_DB);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            result.next();
            return new Owners(result.getInt("owner_id"), result.getString("fio"), result.getInt("age"),
                    result.getString("city"));
        } catch (SQLException e) {
            System.out.print("not found");
            throw new IllegalArgumentException(e);
        }
    }

    public List<Owners> getAll() {
        return null;
    }

    public void delete(Owners owner) {

    }

    public void update(Owners owner) {

    }

    public void add(Owners owner) {

    }
}
