package ru.itis.controllers;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView getWelcome(@RequestParam("login") String login,
                                   @RequestParam("password") String password,
                                   HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        String currentToken = null;

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
            modelAndView.setViewName("login");
        } else {
            modelAndView.setViewName("list");
        }

        return modelAndView;
    }
}

