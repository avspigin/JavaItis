package ru.itis.servlets;

import ru.itis.factory.ServiceFactory;
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

    @Override
    public void init(){

        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        ownerService = ServiceFactory.getInstance().getOwnerService();
        carService = ServiceFactory.getInstance().getCarService();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        getServletContext().getRequestDispatcher("/addAuto.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Cookie cookie[] = request.getCookies();
        if (cookie != null) {
            for (int i = cookie.length - 1; i > 0; i--) {
                List<Owners> list = ownerService.getAllUsers();
                for (Owners currentOwner : list) {
                    if (cookie[i].getValue().equals(currentOwner.getToken())) {
                        String name = request.getParameter("name");
                        int mileage = Integer.parseInt(request.getParameter("mileage"));
                        carService.addCar(new Cars(name, mileage, currentOwner.getUserId()));
                        break;
                    }
                }
            }
        }
        response.sendRedirect("/list");
    }
}
