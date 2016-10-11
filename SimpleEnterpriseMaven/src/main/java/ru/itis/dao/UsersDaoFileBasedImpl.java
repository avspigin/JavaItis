package ru.itis.dao;

import com.google.common.base.Splitter;
import ru.itis.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UsersDaoFileBasedImpl implements UsersDao {

    private BufferedReader fileReader;
    private Properties properties;
    private String originFilePath;
    private String supportFilePath;


    /**
     * Конструктор загружает данные с файла users и временного файла tmpUsers,
     * с помощью файла filePath.properties
     */
    public UsersDaoFileBasedImpl() throws IOException {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\Span\\Desktop\\JavaItis\\" +
                    "SimpleEnterpriseMaven\\src\\main\\resources\\filePath.properties"));  //загружает данные с файла пропертис
            originFilePath = properties.getProperty("originPath"); //берет строку с путем файла оригинал
            supportFilePath = properties.getProperty("supportPath");  //берет строку с путем файла временный

            fileReader = new BufferedReader(new FileReader(originFilePath)); //выгружает в буфер данные файла юзерс
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     *
     * @return возвращает список юзеров
     */
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try {
            String currentLine = fileReader.readLine(); //считывает первую строку
            while (currentLine != null) { //пока не пустой
                User currentUser = parseStringAsUser(currentLine); //Передает в созданный объект юзер из метода
                result.add(currentUser); //добавляет в лист
                currentLine = fileReader.readLine(); //получается переводит на след. строку и считывает новую
            }
        } catch (IOException e) {
            System.out.println("SomeError");
        }
        return result;
    }

    /**
     * Метод находит в файле пользователя по id
     * @param userId
     * @return user
     */
    public User get(int userId) {
        List<User> currentUsers = getAll();
        User result = null;
        for (User user : currentUsers) {
            if (user.getId() == userId){
                result = user;
            }
        }
        if (result == null) System.out.println("User not found!");
        return result;
    }

    /**
     * Метод сохраняет в файл нового юзера с полями
     * @param user
     */
    public void save(User user) {
        try{
            /**
             * В буфер загружает файл FileWriter(путь фала, если true - дозапись иначе перезапись)
             * @param
             */
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(originFilePath, true));
            bufferedWriter.newLine(); //перевод на новую строку
            bufferedWriter.write(user.getId() + " " + user.getName() + " " +
                    user.getPassword() + " " + user.getAge());//записывает сохраняет в файл
            bufferedWriter.flush();// очень важно использовать при записи, проверяет что запись была, и убирает с буфера.
            bufferedWriter.close();// закрывает буф.
        }catch(Exception e){

            System.out.print(e.getMessage());

        }
    }

    /**
     * Метод считывает с оригинального файла строки, построчно записывает
     * на временный файл, если находит то пропускает и при повторном вызове, сменив аргументы,
     * сохраняет в оригинал
     * @param reader то откуда чтение
     * @param writer то куда записывать
     * @param lineToDelete линия на удаление
     */
    public void replace(BufferedReader reader, BufferedWriter writer, String lineToDelete){
        String currentLine;
        try {
            while((currentLine = reader.readLine()) != null){ //присваевает текуцую строку и проверяет на наличие
                String trimLine = currentLine.trim(); //удаляет пробелы до и после текста
                if(trimLine.equals(lineToDelete)) continue; // если строка на удаление равнозначна текущей то пропуск
                writer.write(currentLine + System.getProperty("line.separator")); // запись текущей строки + перенос на новую ("line.separator")
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаляет сртоку по id.
     * @param userId
     */
    public void delete(int userId) {
        User currentUser = get(userId);
        String lineToDelete = currentUser.getId() + " " + currentUser.getName() + " " +
                currentUser.getPassword() + " " + currentUser.getAge(); //приводит объект в строку

        try {
            BufferedReader reader = new BufferedReader(new FileReader(originFilePath)); //считывает с оригинального файла
            BufferedWriter writer = new BufferedWriter(new FileWriter(supportFilePath)); //запись во временный файл

            replace(reader, writer, lineToDelete); //метод если находит строку, до не записывает во временный файл

            reader.close();
            writer.flush();
            writer.close();

            reader = new BufferedReader(new FileReader(supportFilePath));
            writer = new BufferedWriter(new FileWriter(originFilePath));

            replace(reader, writer, "Empty"); //теперь обратно перезаписываем в оригинальный файл в качестве поараметра любая строка

            reader.close();
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /**
     * Используя библиотеку Mockito данный метод преобразует строку в объект юзер
     * @param line текстовая строка с данными юзера
     * @return
     */
    private User parseStringAsUser(String line) {
        Splitter splitter = Splitter.on(" "); //Указываем разделитель из строки

        List<String> lines = splitter.splitToList(line); //создает список из отдельных слов


        int id = Integer.parseInt(lines.get(0));
        String name = lines.get(1);
        String password = lines.get(2);
        int age = Integer.parseInt(lines.get(3));


        return new User(id, name, password, age);
    }
}
