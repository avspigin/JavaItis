package ru.itis;

import ru.itis.dao.OwnersDao;
import ru.itis.dao.OwnersDaoJdbcImpl;
import ru.itis.factory.ConnectionFactory;
import ru.itis.factory.DaoFactory;
import ru.itis.factory.ServiceFactory;
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

        ownerService.deleteOwner(10);

        List<Owners> ownerses = ownerService.getAllUser();
        for(Owners owner: ownerses) {
            System.out.println(owner.getFio() + " " + owner.getCity());
        }

        System.out.println(carService.findCarById(2).getName());


    }
}
