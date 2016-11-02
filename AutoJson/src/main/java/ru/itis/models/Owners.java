package ru.itis.models;

import com.google.common.base.MoreObjects;

/**
 * Created by Span on 23.10.2016.
 */
public class Owners {
    private int userId;
    private String userLogin;
    private String userPassword;
    private String userFio;
    private int age;
    private String token;

    public Owners(int userId, String userLogin, String userPassword, String userFio, int age, String token) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userFio = userFio;
        this.age = age;
        this.token = token;
    }

    public Owners(int userId, String userLogin, String userPassword, String userFio, int age) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userFio = userFio;
        this.age = age;
    }

    public Owners(String userLogin, String userPassword, String userFio, int age) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userFio = userFio;
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFio() {
        return userFio;
    }

    public void setUserFio(String userFio) {
        this.userFio = userFio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
                .add(" User Id", this.userId)
                .add(" User login", this.userLogin)
                .add(" FIO", this.userFio)
                .add(" Age", this.age)
                .toString();

    }
}
