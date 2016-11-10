package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Cars;
import ru.itis.models.Owners;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class AddAutoControllers extends HttpServlet {

    @Autowired
    private OwnerService ownerService;
    @Autowired
    private CarService carService;
    private Owners owner;

    @RequestMapping(value ="/addAuto", method = RequestMethod.GET)
    public ModelAndView handleRequest(@CookieValue("token") String token) {
        ModelAndView modelAndView = new ModelAndView();

        List<Cars> cars = carService.getAllCars();

        if (token != null) {
            List<Owners> list = ownerService.getAllUsers();
            for (Owners currentOwner : list) {
                if (token.equals(currentOwner.getToken())) {
                    owner = currentOwner;
                }
            }
        }

        modelAndView.addObject("owner", owner);
        modelAndView.addObject("carsForJsp", cars);
        modelAndView.setViewName("addAuto");
        return modelAndView;
    }

    @RequestMapping(value = "/addAuto", method = RequestMethod.POST)
    public ModelAndView addCar(@RequestParam("name") String name,
                               @RequestParam("mileage") String mileage,
                               @CookieValue("token") String token){
        ModelAndView modelAndView = new ModelAndView();

        if(!name.equals("") || !mileage.equals("")){
            int mileageInt = Integer.parseInt(mileage);
            carService.addCar(new Cars(name, mileageInt, owner.getUserId()));
        }

        List<Cars> cars = carService.getAllCars();

        if (token != null) {
            List<Owners> list = ownerService.getAllUsers();
            for (Owners currentOwner : list) {
                if (token.equals(currentOwner.getToken())) {
                    owner = currentOwner;
                }
            }
        }

        modelAndView.addObject("owner", owner);
        modelAndView.addObject("carsForJsp", cars);

        modelAndView.setViewName("addAuto");
        return modelAndView;
    }
}
