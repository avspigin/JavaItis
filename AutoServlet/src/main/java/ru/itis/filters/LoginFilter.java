package ru.itis.filters;

import ru.itis.factory.ServiceFactory;
import ru.itis.models.Owners;
import ru.itis.services.OwnerService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Span on 24.10.2016.
 */
public class LoginFilter implements Filter{

    private OwnerService ownerService;


    public void init(FilterConfig filterConfig) throws ServletException {

        ownerService = ServiceFactory.getInstance().getOwnerService();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        Cookie cookie[] = ((HttpServletRequest) servletRequest).getCookies();
        if (cookie != null){
            for (int i = cookie.length-1; i > 0; i--){
                List<Owners> list = ownerService.getAllUsers();
                for (Owners owner: list){
                    if (cookie[i].getValue().equals(owner.getToken())){
                        filterChain.doFilter(servletRequest, servletResponse);
                        break;
                    }
                }
            }
        }
    }

    public void destroy() {

    }

}
