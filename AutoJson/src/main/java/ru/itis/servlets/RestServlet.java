package ru.itis.servlets;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import org.springframework.context.ApplicationContext;
        import ru.itis.models.Cars;
        import ru.itis.models.Owners;
        import ru.itis.services.CarService;
        import ru.itis.services.OwnerService;
        import java.io.IOException;
        import java.util.List;
        import java.util.regex.Pattern;
        import java.util.regex.Matcher;
        import javax.servlet.ServletConfig;
        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import static ru.itis.converters.ModelConverter.getCarDto;
        import static ru.itis.converters.ModelConverter.getOwnerDto;

public class RestServlet extends HttpServlet {

    private OwnerService ownerService;
    private CarService carService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext servletContext = config.getServletContext();
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute("context");
        objectMapper = new ObjectMapper();
        ownerService = (OwnerService) context.getBean("ownerService");
        carService = (CarService) context.getBean("carService");

        servletContext.log("Connect RestServlet");
    }

    private class RestRequest {
        // Accommodate two requests, one for all resources, another for a specific resource
        private Pattern getAllOwners = Pattern.compile("/users");
        private Pattern getCar = Pattern.compile("/users/([0-9]+)/cars");

        private boolean users;
        private Integer idUsers;

        public RestRequest(String pathInfo) throws ServletException {
            // regex parse pathInfo
            Matcher matcher;
            users = false;

            // Check for ID case first, since the All pattern would also match
            matcher = getCar.matcher(pathInfo);
            if (matcher.find()) {
                idUsers = Integer.parseInt(matcher.group(1));
                return;
            }

            matcher = getAllOwners.matcher(pathInfo);
            if (matcher.find()) {
                users = true;
                return;
            }
            throw new ServletException("Invalid URI");
        }

        public Integer getIdUsers() {
            return idUsers;
        }

        public boolean isUsers() {
            return users;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RestRequest resourceValues = new RestRequest(request.getPathInfo());
        if (resourceValues.isUsers()) {
            if (request.getParameter("age") != null) {
                List<Owners> ownersList = ownerService.findUserByAge(Integer.parseInt(request.getParameter("age")));
                for (Owners owner: ownersList) {
                    String stringResponse = objectMapper.writeValueAsString(getOwnerDto(owner));
                    response.setContentType("application/json; charset=UTF-8");
                    response.getWriter().write(stringResponse + "\n");
                }
            } else {
                List<Owners> listOwners = ownerService.getAllUsers();
                for (Owners owner : listOwners) {
                    String stringResponse = objectMapper.writeValueAsString(getOwnerDto(owner));
                    response.setContentType("application/json; charset=UTF-8");
                    response.getWriter().write(stringResponse + "\n");
                }
            }
        } else {
            List<Cars> listCars = ownerService.getCarsOfOwner(resourceValues.getIdUsers());
            for (Cars car : listCars) {
                String stringResponse = objectMapper.writeValueAsString(getCarDto(car));
                response.setContentType("application/json; charset=UTF-8");
                response.getWriter().write(stringResponse + "\n");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

//        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String mileageStr = request.getParameter("mileage");
        if(name != null && mileageStr != null) {
            int mileage = Integer.parseInt(mileageStr);
            RestRequest resourceValues = new RestRequest(request.getPathInfo());
            carService.addCar(new Cars(name, mileage, resourceValues.getIdUsers()));
        }
    }

}