package ru.itis.dao;

import ru.itis.models.Cars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Span on 23.10.2016.
 */
public class CarDaoImpl implements CarDao {

    private Connection connection;

    //language=SQL
    private static final String SQL_GET_CAR = "SELECT * FROM cars WHERE car_id = ?";
    //language=SQL
    private static final String SQL_GET_ALL_CAR = "SELECT * FROM cars";
    //language=SQL
    private static final String SQL_UPDATE_CAR = "UPDATE cars SET car_name = ?, " +
            "mileage = ?, user_id = ? WHERE car_id = ?";
    //language=SQL
    private static final String SQL_DELETE_CAR = "DELETE FROM cars WHERE car_id = ?";
    //language=SQL
    private static final String SQL_ADD_CAR = "INSERT INTO cars (car_name, mileage, user_id) VALUES (?, ?, ?)";

    public CarDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public Cars getCar(int carId) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_GET_CAR);
            statement.setInt(1, carId);
            ResultSet result = statement.executeQuery();
            result.next();
            return new Cars(result.getInt("car_id"), result.getString("car_name"),
                    result.getInt("mileage"), result.getInt("user_id"));

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Cars> getAllCars() {
        List<Cars> list = new ArrayList<Cars>();
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_CAR);

            ResultSet result = statement.executeQuery();
//            result.next();
            while (result.next()) {
                list.add(new Cars(result.getInt("car_id"), result.getString("car_name"),
                        result.getInt("mileage"), result.getInt("user_id")));
            }

            return list;

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void addCar(Cars car) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_ADD_CAR);
            statement.setString(1, car.getCarName());
            statement.setInt(2, car.getCarMileage());
            statement.setInt(3, car.getUserId());
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void updateCar(Cars car) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_CAR);
            statement.setInt(4, car.getCarId());
            statement.setString(1, car.getCarName());
            statement.setInt(2, car.getCarMileage());
            statement.setInt(3, car.getUserId());
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void deleteCar(int carId) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_CAR);
            statement.setInt(1, carId);
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
