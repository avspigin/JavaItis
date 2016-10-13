package ru.itis.models;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class Cars {

    private int id;
    private String name;
    private int mileage;


    private int ownerId;

    public Cars(int id, String name, int mileage) {
        this.id = id;
        this.name = name;
        this.mileage = mileage;
    }

    public Cars(int id, String name, int mileage, int ownerId) {
        this.id = id;
        this.name = name;
        this.mileage = mileage;
        this.ownerId = ownerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

}