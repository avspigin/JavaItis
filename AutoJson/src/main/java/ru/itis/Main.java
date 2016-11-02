package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.Owners;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import java.util.List;

/**
 * Created by Span on 23.10.2016.
 */
public class Main {
    public static void main(String[] args) {

//        OwnerService ownerService = ServiceFactory.getInstance().getOwnerService();
//        CarService carService = ServiceFactory.getInstance().getCarService();

        OwnerService ownerService;
        CarService carService;

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ownerService = (OwnerService) applicationContext.getBean("ownerService");
        carService = (CarService) applicationContext.getBean("carService");

        carService.deleteCar(10);

       /* Owners owner1 = ownerService.findUserById(14);
        owner1.setToken("werrqwerqr");
        ownerService.setToken(owner1);*/

        List<Owners> list = ownerService.getAllUsers();
        for (Owners owner:list){
            System.out.println(owner);
        }

//        List<Cars> list1 = carService.getAllCars();
//        for (Cars car:list1){
//            System.out.println(car);
//        }

    }
}
