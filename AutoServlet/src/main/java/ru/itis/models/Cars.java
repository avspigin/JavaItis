package ru.itis.models;

import com.google.common.base.MoreObjects;

/**
 * Created by Span on 23.10.2016.
 */
public class Cars {

    private int carId;
    private String carName;
    private int carMileage;
    private int userId;

    public Cars(int carId, String carName, int carMileage, int userId) {
        this.carId = carId;
        this.carName = carName;
        this.carMileage = carMileage;
        this.userId = userId;
    }

    public Cars(String carName, int carMileage, int userId) {
        this.carName = carName;
        this.carMileage = carMileage;
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
                .add(" Car id", this.carId)
                .add(" Car name", this.carName)
                .add(" Car mileage", this.carMileage)
                .add(" Owner id", this.userId)
                .toString();
    }
}
