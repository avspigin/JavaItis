package ru.itis;


import ru.itis.factory.ServiceFactory;
import ru.itis.models.Cars;
import ru.itis.models.Owners;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by KFU-user on 12.10.2016.
 */
public class Main {

    public static void main(String[] args) {

        OwnerService ownerService = ServiceFactory.getInstance().getOwnersService();
        CarService carService = ServiceFactory.getInstance().getCarService();
//        System.out.println(ownerService.findUserById(2).getFio());
//

//      ownerService.updateOwner(new Owners(10, "Lera", 23, "Polis"));

//        ownerService.deleteOwner(10);

        List<Owners> owners = ownerService.getAllUser();
        for(Owners owner: owners) {
            System.out.println(owner);
        }

        System.out.println("=============================================================");

        List<Cars> cars = carService.getAllCars();
        for(Cars currentCar: cars){
            System.out.println(currentCar);
        }

//        System.out.println(carService.findCarById(2).getName());

        System.out.println(carService.findCarById(12));



    }
}
