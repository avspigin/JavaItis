package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.Cars;
import ru.itis.models.Owners;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Span on 24.10.2016.
 */
public class AddAutoServlet extends HttpServlet {

    private OwnerService ownerService;
    private CarService carService;
    private Owners owner;

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

        List<Cars> cars = carService.getAllCars();

        Cookie cookie[] = request.getCookies();

        if (cookie != null) {
            for (int i = cookie.length - 1; i > 0; i--) {
                List<Owners> list = ownerService.getAllUsers();
                for (Owners currentOwner : list) {
                    if (cookie[i].getValue().equals(currentOwner.getToken())) {
                        owner = currentOwner;
                    }
                }
            }
        }

        request.setAttribute("owner", owner);
        request.setAttribute("carsForJsp", cars);

        getServletContext().getRequestDispatcher("/addAuto.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String mileageString = request.getParameter("mileage");
        if (!name.equals("") || !mileageString.equals("")){
            int mileage = Integer.parseInt(mileageString);
            carService.addCar(new Cars(name, mileage, owner.getUserId()));
        }

        response.sendRedirect("/addAuto");
//        if (empty){
//        }else {
//            response.sendRedirect("/list");
//        }
    }
}
