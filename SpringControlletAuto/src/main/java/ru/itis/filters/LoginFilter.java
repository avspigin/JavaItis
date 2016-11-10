package ru.itis.filters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    private boolean cookieTrue = false;


    public void init(FilterConfig filterConfig) throws ServletException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ownerService = (OwnerService) applicationContext.getBean("ownerService");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setContentType("text/html; charset=UTF-8");
        Cookie cookie[] = ((HttpServletRequest) servletRequest).getCookies();
        if (cookie != null){
            for (int i = cookie.length-1; i > 0; i--){
                List<Owners> list = ownerService.getAllUsers();
                for (Owners owner: list){
                    if (cookie[i].getValue().equals(owner.getToken())){
                        cookieTrue = true;
                        break;
                    }
                }
            }
        }
        if (cookieTrue){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter().print("Для просмотра данной страницы необходима авторизация");
        }
    }

    public void destroy() {

    }

}
