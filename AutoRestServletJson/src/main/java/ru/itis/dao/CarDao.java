package ru.itis.dao;

import ru.itis.models.Cars;

import java.util.List;

/**
 * Created by Span on 23.10.2016.
 */
public interface CarDao {
    Cars getCar(int carId);
    List<Cars> getAllCars();
    void addCar(Cars car);
    void updateCar(Cars car);
    void deleteCar(int carId);
}
