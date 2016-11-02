package ru.itis.dao;

import ru.itis.models.Cars;
import ru.itis.models.Owners;

import java.util.List;

/**
 * Created by Span on 23.10.2016.
 */
public interface OwnerDao {
    void setToken(Owners owners);
    Owners getOwner(int userId);
    Owners findByAge(int age);
    List<Owners> getAllOwners();
    void addOwner(Owners owner);
    void updateOwner(Owners owner);
    void deleteOwner(int userId);
    List<Cars> getCarsOfOwner(int userId);
}
