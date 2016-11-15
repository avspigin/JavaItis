package ru.itis.dto;

/**
 * Created by Артём on 02.11.2016.
 */
public class CarDto {

    private String carName;
    private int carMileage;

    public CarDto() {
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
}
