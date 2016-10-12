package ru.itis.dao;

import ru.itis.models.Cars;

import java.util.List;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class CarsDaoJdbcImpl implements CarsDao {

    // language=SQL
    private static final String SQL_SELECT_FROM_DB = "SELECT * FROM cars WHERE car_id = ?";
    // language=SQL
    private static final String SQL_DELETE_FROM_DB = "DELETE FROM cars WHERE car_id = ?";
    // language=SQL
    private static final String SQL_UPDATE_DB = "UPDATE cars SET car_name = ?, mileage = ?, owner_id = ? WHERE car_id = ?";
    // language=SQL
    private static final String SQL_ADD_TO_DB = "INSERT INTO cars (car_name, mileage, owner_id) VALUES (?, ?, ?);";


    public Cars find(int id) {
        return null;
    }

    public List<Cars> getAll() {
        return null;
    }

    public void delete(Cars car) {

    }

    public void update(Cars car) {

    }

    public void add(int id, String name, int age, int ownerId) {

    }
}
