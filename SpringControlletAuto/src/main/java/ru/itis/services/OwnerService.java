package ru.itis.services;

import ru.itis.models.Cars;
import ru.itis.models.Owners;

import java.util.List;

/**
 * Created by Span on 23.10.2016.
 */
public interface OwnerService {
    void setToken(Owners owner);
    Owners findUserById(int userId);
    List<Owners> findUserByAge(int age);
    List<Owners> getAllUsers();
    void addUser(Owners owner);
    void updateUser(Owners owner);
    void deleteUser(int userId);
    List<Cars> getCarsOfOwner(int userId);
}
