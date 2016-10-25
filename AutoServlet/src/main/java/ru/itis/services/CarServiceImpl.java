package ru.itis.services;

import ru.itis.dao.CarDao;
import ru.itis.models.Cars;

import java.util.List;

/**
 * Created by Span on 24.10.2016.
 */
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    public Cars findCarrById(int carId) {
        return carDao.getCar(carId);
    }

    public List<Cars> getAllCars() {
        return carDao.getAllCars();
    }

    public void addCar(Cars car) {
        carDao.addCar(car);
    }

    public void updateCar(Cars car) {
        carDao.updateCar(car);
    }

    public void deleteCar(int carId) {
        carDao.deleteCar(carId);
    }
}
