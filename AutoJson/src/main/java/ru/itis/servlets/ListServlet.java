package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.Cars;
import ru.itis.models.Owners;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {

    private OwnerService ownerService;
    private CarService carService;

    @Override
    public void init(){

        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ownerService = (OwnerService) applicationContext.getBean("ownerService");
        carService = (CarService) applicationContext.getBean("carService");
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        List<Owners> owners = ownerService.getAllUsers();
        List<Cars> cars = carService.getAllCars();

        request.setAttribute("ownersForJsp", owners);
        request.setAttribute("carsForJsp", cars);
        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    }
}
