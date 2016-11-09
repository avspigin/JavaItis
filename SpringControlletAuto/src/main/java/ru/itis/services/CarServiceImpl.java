package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.dao.CarDao;
import ru.itis.models.Cars;

import java.util.List;


@Service
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
