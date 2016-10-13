package ru.itis.services;

import ru.itis.models.Cars;
import ru.itis.models.Owners;

import java.util.List;

/**
 * Created by Span on 13.10.2016.
 */
public interface CarService {
    Cars findCarById(int id);
    List<Cars> getAllCars();
    void deleteCar(int id);
    void updateCar(Cars car);
    void addCar(Cars car);
}
