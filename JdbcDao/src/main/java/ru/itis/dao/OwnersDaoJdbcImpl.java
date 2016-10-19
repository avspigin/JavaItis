package ru.itis.dao;


import ru.itis.models.Owners;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class OwnersDaoJdbcImpl implements OwnersDao {

    private Connection connection;
    Owners owners;

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
    // language=SQL
    private static final String SQL_SELECT_COPLE_ALL = "SELECT owners_id, fio, age, city, car_name, mileage FROM owners, cars WHERE owners.owner_id=cars.owner_id;";

    public OwnersDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public Owners find(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FROM_DB);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            result.next();
            return new Owners(result.getInt("owner_id"), result.getString("fio"), result.getInt("age"),
                    result.getString("city"));

        } catch (SQLException e) {
            System.out.print("Id not found!");
            throw new IllegalArgumentException();
        }

    }

    public List<Owners> getAll() {
        try {
            List<Owners> list = new ArrayList<Owners>();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_FROM_DB);

            ResultSet result = statement.executeQuery();
            result.next();
            while(result.next()) {
                list.add(new Owners(result.getInt("owner_id"), result.getString("fio"), result.getInt("age"),
                        result.getString("city")));
            }

            return list;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void coupleOwnersCars(){

    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_FROM_DB);
            statement.setInt(1, id);
            System.out.println("Deleted!");
            statement.execute();

        } catch (SQLException e) {
            System.out.print("Id not found!");
        }

    }

    public void update(Owners owner) {
        try {

            this.owners  = owner;
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_DB);
            statement.setInt(4, owner.getId());
            statement.setString(1, owner.getFio());
            statement.setInt(2, owner.getAge());
            statement.setString(3, owner.getCity());
            System.out.println("Updated!");
            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void add(Owners owner) {
        try {

            this.owners  = owner;
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_TO_DB);
            statement.setString(1, owner.getFio());
            statement.setInt(2, owner.getAge());
            statement.setString(3, owner.getCity());
            statement.execute();
            System.out.println("Added!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
