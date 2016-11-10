package ru.itis.dto;

/**
 * Created by Артём on 02.11.2016.
 */
public class OwnerDto {

    private String userLogin;
    private String userFio;
    private int age;

    public OwnerDto() {
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
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
}
