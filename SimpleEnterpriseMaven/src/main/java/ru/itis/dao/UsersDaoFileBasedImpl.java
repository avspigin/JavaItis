package ru.itis.dao;

import com.google.common.base.Splitter;
import ru.itis.models.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoFileBasedImpl implements UsersDao {

    private BufferedReader fileReader;


    public UsersDaoFileBasedImpl(String fileName) { // метод выводит данные с файла.
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public List<User> getAll() {   // возвращает список юзеров
        List<User> result = new ArrayList<>();
        try {
            String currentLine = fileReader.readLine(); //считывает первую строку
            while (currentLine != null) { //пока не пустой
                User currentUser = parseStringAsUser(currentLine); //Передает созданный объект юзер из метода
                result.add(currentUser); //добавляет в лист
                currentLine = fileReader.readLine(); //получается переводит на след. строку и считывает новую
            }
        } catch (IOException e) {
            System.out.println("SomeError");
        }
        return result;
    }

    public User get(int userId) {

        List<User> result = new ArrayList<>();
        try {
            String currentLine = fileReader.readLine();
            while (currentLine != null) {
                User currentUser = parseStringAsUser(currentLine);
                result.add(currentUser);
                currentLine = fileReader.readLine();

            }
        } catch (IOException e) {
            System.out.println("SomeError");
        }

        for (User user : result) {
            if (user.getId() == userId){
                return user;
            }
        }
        System.out.println("User not found!");
        return null;
    }

    public void save(User user) {

    }

    public void delete(int userId) {

    }

    private User parseStringAsUser(String line) {
        Splitter splitter = Splitter.on(" ");

        List<String> lines = splitter.splitToList(line);

        int id = Integer.parseInt(lines.get(0));
        String name = lines.get(1);
        String password = lines.get(2);
        int age = Integer.parseInt(lines.get(3));


        return new User(id, name, password, age);
    }
}
