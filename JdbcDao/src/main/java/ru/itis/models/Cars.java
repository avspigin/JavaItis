package ru.itis.models;

import com.google.common.base.MoreObjects;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class Cars {

    private int id;
    private String name;
    private int mileage;



    public Cars(int id, String name, int mileage) {
        this.id = id;
        this.name = name;
        this.mileage = mileage;
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



    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
                .add("  car_id", this.id)
                .add("  car_name", this.name)
                .add("  mileage", this.mileage)
                .toString();
    }

}