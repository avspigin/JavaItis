package ru.itis.services;

import ru.itis.dao.CarDao;
import ru.itis.dao.OwnerDao;
import ru.itis.models.Cars;
import ru.itis.models.Owners;

import java.util.List;

/**
 * Created by Span on 23.10.2016.
 */
public class OwnerServiceImpl implements OwnerService {
    OwnerDao ownerDao;

    public OwnerServiceImpl(OwnerDao ownerDao){
        this.ownerDao = ownerDao;
    }

    public void setToken(Owners owner){
        this.ownerDao.setToken(owner);
    }

    public Owners findUserById(int userId) {
        return ownerDao.getOwner(userId);
    }

    public List<Owners> findUserByAge(int age){
        return ownerDao.findByAge(age);
    }

    public List<Owners> getAllUsers() {
        return ownerDao.getAllOwners();
    }

    public void addUser(Owners owner) {
        this.ownerDao.addOwner(owner);
    }

    public void updateUser(Owners owner) {
        this.ownerDao.updateOwner(owner);
    }

    public void deleteUser(int userId) {
        this.ownerDao.deleteOwner(userId);
    }

    public List<Cars> getCarsOfOwner(int userId){
        return ownerDao.getCarsOfOwner(userId);
    }
}
