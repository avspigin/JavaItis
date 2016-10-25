package ru.itis;

import ru.itis.factory.ServiceFactory;
import ru.itis.models.Cars;
import ru.itis.models.Owners;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import java.util.List;

/**
 * Created by Span on 23.10.2016.
 */
public class Main {
    public static void main(String[] args) {

        OwnerService ownerService = ServiceFactory.getInstance().getOwnerService();
        CarService carService = ServiceFactory.getInstance().getCarService();


        Owners owner1 = ownerService.findUserById(14);
        owner1.setToken("werrqwerqr");
        ownerService.setToken(owner1);
        List<Owners> list = ownerService.getAllUsers();
        for (Owners owner:list){
            System.out.println(owner);
        }

        List<Cars> list1 = carService.getAllCars();
        for (Cars car:list1){
            System.out.println(car);
        }

    }
}
