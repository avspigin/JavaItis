package ru.itis.dao;

import ru.itis.models.Owners;

import java.util.List;

/**
 * Created by KFU-user on 12.10.2016.
 */
public interface OwnersDao {
        Owners find(int id);
        List<Owners> getAll();
        void delete(Owners owner);
        void update(Owners owner);
        void add(Owners owner);
}
