package ru.itis;

        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;
        import ru.itis.models.Owners;
        import ru.itis.services.OwnerService;

        import java.io.IOException;
        import java.io.PrintWriter;

        import java.util.List;
        import java.util.regex.Pattern;
        import java.util.regex.Matcher;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

public class TestRestServlet extends HttpServlet {

    OwnerService ownerService;
    @Override
    public void init(){

        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ownerService = (OwnerService) applicationContext.getBean("ownerService");

    }


    private class RestRequest {

        List<Owners> ownersList;
        Owners owner;
        // Accommodate two requests, one for all resources, another for a specific resource
        private Pattern regExAllPattern = Pattern.compile("/users");
        private Pattern regExIdPattern = Pattern.compile("/users/([0-9]*)");

        private Integer id;

        public RestRequest(String pathInfo) throws ServletException {
            // regex parse pathInfo
            Matcher matcher;

            // Check for ID case first, since the All pattern would also match
            matcher = regExIdPattern.matcher(pathInfo);
            if (matcher.find()) {
                id = Integer.parseInt(matcher.group(1));
                return;
            }

            matcher = regExAllPattern.matcher(pathInfo);
            if (matcher.find()) return;

            throw new ServletException("Invalid URI");
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void getAllOwners(){
            this.ownersList = ownerService.getAllUsers();
        }

        public void getOwner(int id){
            List<Owners> list = ownerService.getAllUsers();
            for (Owners currentOwner: list){
                if (currentOwner.getUserId() == id){
                    this.owner = currentOwner;
                    return;
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        /*out.println("GET request handling");
        out.println(request.getPathInfo());
        out.println(request.getParameterMap());
        try {
            RestRequest resourceValues = new RestRequest(request.getPathInfo());
            out.println(resourceValues.getId());
        } catch (ServletException e) {
            response.setStatus(400);
            response.resetBuffer();
            e.printStackTrace();
            out.println(e.toString());
        }
        out.close();*/
    }
}