package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Cars;
import ru.itis.models.Owners;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class ListControllers extends HttpServlet {


    @Autowired
    private OwnerService ownerService;
    @Autowired
    private CarService carService;



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView handleRequest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");

        List<Owners> owners = ownerService.getAllUsers();
        List<Cars> cars = carService.getAllCars();

        modelAndView.addObject("ownersForJsp", owners);
        modelAndView.addObject("carsForJsp", cars);

        return modelAndView;

    }
}
