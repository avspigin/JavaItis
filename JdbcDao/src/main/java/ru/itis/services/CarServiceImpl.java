package ru.itis.services;

import ru.itis.dao.CarsDao;
import ru.itis.models.Cars;

import java.util.List;

/**
 * Created by Span on 13.10.2016.
 */
public class CarServiceImpl implements CarService {

    private CarsDao carsDao;

    public CarServiceImpl(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    public Cars findCarById(int id) {
        return this.carsDao.find(id);
    }

    public List<Cars> getAllCars() {
        return this.carsDao.getAll();
    }

    public void deleteCar(int id) {
        this.carsDao.delete(id);
    }

    public void updateCar(Cars car) {
        this.carsDao.update(car);
    }

    public void addCar(Cars car) {
        this.carsDao.add(car);
    }
}
