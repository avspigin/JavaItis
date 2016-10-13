package ru.itis;

import ru.itis.dao.OwnersDao;
import ru.itis.dao.OwnersDaoJdbcImpl;


/**
 * Created by KFU-user on 12.10.2016.
 */
public class Main {

    public static void main(String[] args) {

        OwnersDao ownersDao = new OwnersDaoJdbcImpl();

        System.out.println(ownersDao.find(2));


        /*try {
            Statement statement = JdbcConnection.getInstance().getConnection().createStatement();

        ResultSet result = null;
        result = statement.executeQuery("SELECT car_id, car_name FROM cars, " +
                "owners WHERE owners.city = 'Казань' AND " +
                "cars.owner_id = owners.owner_id");
        while(result.next()) {
            System.out.println(result.getInt("car_id") +
                    " " + result.getString("car_name"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
