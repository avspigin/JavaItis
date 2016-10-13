package ru.itis.services;

import ru.itis.dao.OwnersDao;
import ru.itis.models.Owners;

import java.util.List;

/**
 * Created by Span on 13.10.2016.
 */
public class OwnerServiceImpl implements OwnerService {

    private OwnersDao ownersDao;

    public OwnerServiceImpl(OwnersDao ownersDao) {
        this.ownersDao = ownersDao;
    }

    public Owners findUserById(int id) {
        return ownersDao.find(id);
    }

    public List<Owners> getAllUser() {
        return ownersDao.getAll();
    }

    public void deleteOwner(int id) {
        this.ownersDao.delete(id);

    }

    public void updateOwner(Owners owner) {
        this.ownersDao.update(owner);
    }

    public void addOwner(Owners owner) {
        this.ownersDao.add(owner);
    }
}
