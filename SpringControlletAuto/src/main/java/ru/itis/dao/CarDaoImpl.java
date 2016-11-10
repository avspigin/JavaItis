package ru.itis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.models.Cars;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Span on 23.10.2016.
 */
@Repository
public class CarDaoImpl implements CarDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //language=SQL
    private static final String SQL_GET_CAR = "SELECT * FROM cars WHERE car_id = :car_id";
    //language=SQL
    private static final String SQL_GET_ALL_CAR = "SELECT * FROM cars";
    //language=SQL
    private static final String SQL_UPDATE_CAR = "UPDATE cars SET car_name = :car_name, " +
            "mileage = :mileage, user_id = :user_id WHERE car_id = :car_id";
    //language=SQL
    private static final String SQL_DELETE_CAR = "DELETE FROM cars WHERE car_id = :car_id";
    //language=SQL
    private static final String SQL_ADD_CAR = "INSERT INTO cars (car_name, mileage, user_id) VALUES (:car_name, :mileage, :user_id)";

    @Autowired
    public CarDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Cars getCar(int carId) {
        Map<String, Integer> paramsMap = new HashMap<String, Integer>();

        paramsMap.put("car_id", carId);

        return namedParameterJdbcTemplate.queryForObject(SQL_GET_CAR, paramsMap, new RowMapper<Cars>() {

            public Cars mapRow(ResultSet resultSet, int i) throws SQLException {

                return new Cars(resultSet.getInt("car_id"),
                        resultSet.getString("car_name"),
                        resultSet.getInt("mileage"),
                        resultSet.getInt("user_id"));
            }

        });
    }

    public List<Cars> getAllCars() {

        return namedParameterJdbcTemplate.query(SQL_GET_ALL_CAR, new RowMapper<Cars>() {

            public Cars mapRow(ResultSet resultSet, int i) throws SQLException {

                return new Cars(resultSet.getInt("car_id"),
                        resultSet.getString("car_name"),
                        resultSet.getInt("mileage"),
                        resultSet.getInt("user_id"));
            }

        });
    }

    public void addCar(Cars car) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();

        paramsMap.put("car_name", car.getCarName());
        paramsMap.put("mileage", car.getCarMileage());
        paramsMap.put("user_id", car.getUserId());

        namedParameterJdbcTemplate.update(SQL_ADD_CAR, paramsMap);
    }

    public void updateCar(Cars car) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();

        paramsMap.put("car_name", car.getCarName());
        paramsMap.put("mileage", car.getCarMileage());
        paramsMap.put("user_id", car.getUserId());
        paramsMap.put("car_id", car.getCarId());

        namedParameterJdbcTemplate.update(SQL_UPDATE_CAR, paramsMap);
    }

    public void deleteCar(int carId) {
        Map<String, Integer> paramsMap = new HashMap<String, Integer>();

        paramsMap.put("car_id", carId);

        namedParameterJdbcTemplate.update(SQL_DELETE_CAR, paramsMap);
    }
}
