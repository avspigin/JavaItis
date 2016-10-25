package ru.itis.servlets;

import ru.itis.factory.ServiceFactory;
import ru.itis.models.Owners;
import ru.itis.services.OwnerService;
import ru.itis.utils.PasswordCache;
import ru.itis.utils.RandomString;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class LoginServlet extends HttpServlet {

    private OwnerService ownerService;
//    private String currentToken = null;

    @Override
    public void init(){

        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        ownerService = ServiceFactory.getInstance().getOwnerService();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String currentToken = null;

        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("userLogin");
        String password = PasswordCache.getCache(request.getParameter("password"));
        List<Owners> list = ownerService.getAllUsers();
        for (Owners owner: list){
            if ((owner.getUserLogin().equals(login)) && (owner.getUserPassword().equals(password))){
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
            response.sendRedirect("/list");
        } else {
            response.sendRedirect("/login");
        }

    }
}
