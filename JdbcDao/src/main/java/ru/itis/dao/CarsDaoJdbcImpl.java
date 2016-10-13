package ru.itis.dao;

import ru.itis.models.Cars;
import ru.itis.models.Owners;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class CarsDaoJdbcImpl implements CarsDao {

    private Connection connection;
    private Cars car;
    // language=SQL
    private static final String SQL_SELECT_FROM_DB = "SELECT * FROM cars WHERE car_id = ?";
    // language=SQL
    private static final String SQL_SELECT_ALL_FROM_DB = "SELECT * FROM cars";
    // language=SQL
    private static final String SQL_DELETE_FROM_DB_CARS = "DELETE FROM cars WHERE car_id = ?";
    // language=SQL
    private static final String SQL_UPDATE_DB = "UPDATE cars SET car_name = ?, mileage = ?, owner_id = ? WHERE car_id = ?";
    // language=SQL
    private static final String SQL_ADD_TO_DB = "INSERT INTO cars (car_name, mileage, owner_id) VALUES (?, ?, ?);";

    public CarsDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public Cars find(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FROM_DB);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            result.next();
            return new Cars(result.getInt("car_id"), result.getString("car_name"), result.getInt("mileage"),
                    result.getInt("owner_id"));

        } catch (SQLException e) {
            System.out.print("Id not found!");
            throw new IllegalArgumentException();
        }

    }

    public List<Cars> getAll() {
        try {
            List<Cars> list = new ArrayList<Cars>();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_FROM_DB);

            ResultSet result = statement.executeQuery();
            result.next();
            while(result.next()) {
                list.add(new Cars(result.getInt("car_id"), result.getString("car_name"), result.getInt("mileage"),
                        result.getInt("owner_id")));
            }

            return list;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_FROM_DB_CARS);
            statement.setInt(1, id);
            System.out.println("Deleted!");
            statement.execute();

        } catch (SQLException e) {
            System.out.print("Id not found!");
        }
    }

    public void update(Cars car) {
        try {

            this.car  = car;
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_DB);
            statement.setInt(4, car.getId());
            statement.setString(1, car.getName());
            statement.setInt(2, car.getMileage());
            statement.setInt(3, car.getOwnerId());
            System.out.println("Updated!");
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Cars car) {
        try {

            this.car  = car;
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_TO_DB);
            statement.setString(1, car.getName());
            statement.setInt(2, car.getMileage());
            statement.setInt(3, car.getOwnerId());
            statement.execute();
            System.out.println("Added!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
