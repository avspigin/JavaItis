package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
import java.util.logging.Logger;


public class LoginServlet extends HttpServlet {

    private OwnerService ownerService;
    private static Logger log = Logger.getLogger(RegistrationServlet.class.getName());

    @Override
    public void init(){

        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ownerService = (OwnerService) applicationContext.getBean("ownerService");
        log.info("userDao RegistrationServlet initiation");
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
        cookie.setMaxAge(2000);
        response.addCookie(cookie);
        if (currentToken != null) {
            response.sendRedirect("/list");
        } else {
            response.sendRedirect("/login");
        }

    }
}
