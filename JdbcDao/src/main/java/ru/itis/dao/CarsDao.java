package ru.itis.dao;

import ru.itis.models.Cars;

import java.util.List;

/**
 * Created by KFU-user on 12.10.2016.
 */
public interface CarsDao {
    Cars find(int id);
    List<Cars> getAll();
    void delete(int id);
    void update(Cars car);
    void add(Cars car);
}