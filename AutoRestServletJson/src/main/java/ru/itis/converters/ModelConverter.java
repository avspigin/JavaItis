package ru.itis.converters;

import ru.itis.dto.CarDto;
import ru.itis.dto.OwnerDto;
import ru.itis.models.Cars;
import ru.itis.models.Owners;

/**
 * Created by Артём on 02.11.2016.
 */
public class ModelConverter {

    public static OwnerDto getOwnerDto(Owners owner){
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setUserLogin(owner.getUserLogin());
        ownerDto.setUserFio(owner.getUserFio());
        ownerDto.setAge(owner.getAge());
        return ownerDto;
    }

     public static CarDto getCarDto(Cars car){
         CarDto carDto = new CarDto();
         carDto.setCarName(car.getCarName());
         carDto.setCarMileage(car.getCarMileage());
         return carDto;
     }
}
