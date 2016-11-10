package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Owners;
import ru.itis.services.OwnerService;
import ru.itis.utils.PasswordCache;
import ru.itis.utils.RandomString;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController extends HttpServlet {
    @Autowired
    private OwnerService ownerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView handleRequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getLogin(@RequestParam("userLogin") String userLogin,
                                   @RequestParam("password") String password,
                                   HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        String currentToken = null;

        String passwordCache = PasswordCache.getCache(password);
        List<Owners> list = ownerService.getAllUsers();
        for (Owners owner: list){
            if ((owner.getUserLogin().equals(userLogin)) && (owner.getUserPassword().equals(passwordCache))){
                RandomString randomString = new RandomString(10);
                currentToken = randomString.nextString();
                owner.setToken(currentToken);
                ownerService.setToken(owner);
            }
        }
        Cookie cookie = new Cookie("token", currentToken);
        cookie.setMaxAge(600);
        response.addCookie(cookie);
        if (currentToken != null) {
            modelAndView.setViewName("redirect:/list");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}

