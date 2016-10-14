package ru.itis.models;

import com.google.common.base.MoreObjects;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class Owners {
    private int id;
    private String fio;
    private int age;
    private String city;

    public Owners(int id, String fio, int age, String city) {
        this.id = id;
        this.fio = fio;
        this.age = age;
        this.city = city;
    }

    public Owners(String fio, int age, String city) {
        this.fio = fio;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
                .add("owner_id", this.id)
                .add("fio", this.fio)
                .add("age", this.age)
                .add("city", this.city)
                .toString();
    }
}
