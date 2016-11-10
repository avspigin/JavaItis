package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.OwnerDao;
import ru.itis.models.Cars;
import ru.itis.models.Owners;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerDao ownerDao;

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
