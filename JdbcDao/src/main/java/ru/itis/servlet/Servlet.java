package ru.itis.servlet;

import ru.itis.factory.ServiceFactory;
import ru.itis.models.Owners;
import ru.itis.services.OwnerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Span on 19.10.2016.
 */
public class Servlet extends HttpServlet {

    private OwnerService ownerService;

    @Override
    public void init(){
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        ownerService = ServiceFactory.getInstance().getOwnersService();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");


        List<Owners> owners = ownerService.getAllUser();
        PrintWriter out = response.getWriter();
        for(Owners owner: owners) {
            out.println("<p>" + owner + "</p>");
        }

        /*String message = request.getParameterValues("message")[0];
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");*/
    }
}
