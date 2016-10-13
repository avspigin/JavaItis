package ru.itis.services;

import ru.itis.models.Owners;

import java.util.List;

/**
 * Created by Span on 13.10.2016.
 */
public interface OwnerService {
    Owners findUserById(int id);
    List<Owners> getAllUser();
    void deleteOwner(int id);
    void updateOwner(Owners owner);
    void addOwner(Owners owner);
}
