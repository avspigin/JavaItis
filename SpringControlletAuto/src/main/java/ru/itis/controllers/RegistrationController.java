package ru.itis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Owners;
import ru.itis.services.OwnerService;



@Controller
public class RegistrationController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView handleRequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView getRegistration(@RequestParam("login") String login,
                                   @RequestParam("password") String password,
                                   @RequestParam("fio") String fio,
                                   @RequestParam("age") String age) {

        ModelAndView modelAndView = new ModelAndView();

        if (login.equals("") || password.equals("") || fio.equals("") || age.equals("")){
            modelAndView.setViewName("registration");
        } else {
            int ageInt = Integer.parseInt(age);
            ownerService.addUser(new Owners(login, password, fio, ageInt));
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }
}