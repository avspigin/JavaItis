package ru.itis.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.models.Cars;
import ru.itis.models.Owners;
import ru.itis.utils.PasswordCache;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Span on 23.10.2016.
 */
public class OwnerDaoImpl implements OwnerDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    Owners owner;

    //language=SQL
    private static final String SQL_GET_OWNER = "SELECT * FROM owners WHERE user_id = :user_id";
    //language=SQL
    private static final String SQL_GET_CAR_OF_OWNER = "SELECT * FROM cars WHERE user_id = :user_id";
    //language=SQL
    private static final String SQL_FIND_BY_AGE = "SELECT * FROM owners WHERE age = :age";
    //language=SQL
    private static final String SQL_GET_ALL_OWNER = "SELECT * FROM owners";
    //language=SQL
    private static final String SQL_UPDATE_OWNER = "UPDATE owners SET user_login = :user_login, " +
            "user_password = :user_password, fio = :fio, age = :age WHERE user_id = :user_id";
    //language=SQL
    private static final String SQL_DELETE_OWNER = "DELETE FROM owners WHERE user_id = :user_id";
    //language=SQL
    private static final String SQL_ADD_OWNER = "INSERT INTO owners (user_login, user_password, fio, age) " +
            "VALUES (:user_login, :user_password, :fio, :age)";
    //language=SQL
    private static final String SQL_SET_TOKEN = "UPDATE owners SET token = :token WHERE user_id = :user_id";

    public OwnerDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void setToken(Owners owner){
        Map<String, Object> paramsMap = new HashMap<String, Object>();

        paramsMap.put("user_id", owner.getUserId());
        paramsMap.put("token", owner.getToken());

        namedParameterJdbcTemplate.update(SQL_SET_TOKEN, paramsMap);
    }

    public Owners getOwner(int userId) {
        Map<String, Integer> paramsMap = new HashMap<String, Integer>();
        paramsMap.put("user_id", userId);

        return namedParameterJdbcTemplate.queryForObject(SQL_GET_OWNER, paramsMap, new RowMapper<Owners>(){

            public Owners mapRow(ResultSet resultSet, int rowNum) throws SQLException{

                return new Owners(resultSet.getInt("user_id"),
                        resultSet.getString("user_login"),
                        resultSet.getString("user_password"),
                        resultSet.getString("fio"),
                        resultSet.getInt("age"),
                        resultSet.getString("token"));
            }

        });
    }

    public List<Owners> findByAge(int age) {
        Map<String, Integer> paramsMap = new HashMap<String, Integer>();
        paramsMap.put("age", age);

        return namedParameterJdbcTemplate.query(SQL_FIND_BY_AGE, paramsMap, new RowMapper<Owners>(){

            public Owners mapRow(ResultSet resultSet, int rowNum) throws SQLException{

                return new Owners(resultSet.getInt("user_id"),
                        resultSet.getString("user_login"),
                        resultSet.getString("user_password"),
                        resultSet.getString("fio"),
                        resultSet.getInt("age"),
                        resultSet.getString("token"));
            }

        });
    }

    public List<Owners> getAllOwners() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_OWNER, new RowMapper<Owners>() {

            public Owners mapRow(ResultSet resultSet, int rowNum) throws SQLException {

                return new Owners(resultSet.getInt("user_id"),
                        resultSet.getString("user_login"),
                        resultSet.getString("user_password"),
                        resultSet.getString("fio"),
                        resultSet.getInt("age"),
                        resultSet.getString("token"));
            }

        });
    }

    public void addOwner(Owners owner) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();

        String ownerPassword = PasswordCache.getCache(owner.getUserPassword()); //шифрование пароля
        paramsMap.put("user_login", owner.getUserLogin());
        paramsMap.put("user_password", ownerPassword);
        paramsMap.put("fio", owner.getUserFio());
        paramsMap.put("age", owner.getAge());

        namedParameterJdbcTemplate.update(SQL_ADD_OWNER, paramsMap);
    }

    public void updateOwner(Owners owner) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();

        String ownerPassword = PasswordCache.getCache(owner.getUserPassword()); //шифрование пароля)
        paramsMap.put("user_id", owner.getUserId());
        paramsMap.put("user_login", owner.getUserLogin());
        paramsMap.put("user_password", ownerPassword);
        paramsMap.put("fio", owner.getUserFio());
        paramsMap.put("age", owner.getAge());

        namedParameterJdbcTemplate.update(SQL_UPDATE_OWNER, paramsMap);

    }

    public void deleteOwner(int userId) {
        Map<String, Integer> paramsMap = new HashMap<String, Integer>();

        paramsMap.put("user_id", userId);

        namedParameterJdbcTemplate.update(SQL_DELETE_OWNER, paramsMap);
    }

    public List<Cars> getCarsOfOwner(int userId){
        Map<String, Integer> paramsMap = new HashMap<String, Integer>();
        paramsMap.put("user_id", userId);

        return namedParameterJdbcTemplate.query(SQL_GET_CAR_OF_OWNER, paramsMap, new RowMapper<Cars>() {

            public Cars mapRow(ResultSet resultSet, int i) throws SQLException {

                return new Cars(resultSet.getInt("car_id"),
                        resultSet.getString("car_name"),
                        resultSet.getInt("mileage"),
                        resultSet.getInt("user_id"));
            }

        });
    }
}
