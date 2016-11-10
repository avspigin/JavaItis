package ru.itis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.models.Owners;
import ru.itis.utils.PasswordCache;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Span on 23.10.2016.
 */
@Repository
public class OwnerDaoImpl implements OwnerDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    Owners owner;

    //language=SQL
    private static final String SQL_GET_OWNER = "SELECT * FROM owners WHERE user_id = :user_id";
    //language=SQL
    private static final String SQL_GET_ALL_OWNER = "SELECT * FROM owners";
    //language=SQL
    private static final String SQL_UPDATE_OWNER = "UPDATE owners SET user_login = :user_login, " +
            "user_password = :user_password, fio = :fio WHERE user_id = :user_id";
    //language=SQL
    private static final String SQL_DELETE_OWNER = "DELETE FROM owners WHERE user_id = :user_id";
    //language=SQL
    private static final String SQL_ADD_OWNER = "INSERT INTO owners (user_login, user_password, fio) VALUES (:user_login, :user_password, :fio)";
    //language=SQL
    private static final String SQL_SET_TOKEN = "UPDATE owners SET token = :token WHERE user_id = :user_id";

    @Autowired
    public OwnerDaoImpl(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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

        namedParameterJdbcTemplate.update(SQL_ADD_OWNER, paramsMap);
    }

    public void updateOwner(Owners owner) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();

        String ownerPassword = PasswordCache.getCache(owner.getUserPassword()); //шифрование пароля)
        paramsMap.put("user_id", owner.getUserId());
        paramsMap.put("user_login", owner.getUserLogin());
        paramsMap.put("user_password", ownerPassword);
        paramsMap.put("fio", owner.getUserFio());

        namedParameterJdbcTemplate.update(SQL_UPDATE_OWNER, paramsMap);

    }

    public void deleteOwner(int userId) {
        Map<String, Integer> paramsMap = new HashMap<String, Integer>();

        paramsMap.put("user_id", userId);

        namedParameterJdbcTemplate.update(SQL_DELETE_OWNER, paramsMap);
    }
}
