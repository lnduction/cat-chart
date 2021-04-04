package testv;

import java.sql.*;
import java.util.List;

public class TestDataGenerator {

    private static final String JDBC_URL = "jdbc:postgresql://localhost/cats_database";
    private static final String JDBC_USERNAME = "cats_tester";
    private static final String JDBC_PASSWORD = "cats_tester";

    private static final String PHOTO_PATH = "media/photo/";


    public static void main(String[] args) throws Exception {
        List<Profile> profiles = getProfiles();
        List<Cat> cats = getCats();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            connection.setAutoCommit(false);
            clearDatabase(connection);
            for (Profile profile : profiles) {
                insertProfiles(connection, profile);
                System.out.println("Profile " + profile.toString() + " was created");
            }
            for (Cat cat : cats) {
                insertCats(connection, cat);
                System.out.println("Cat " + cat.toString() + " was created");
            }
            connection.commit();
            System.out.println("Data generated successful");
        }
    }
    private static void clearDatabase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from vote");
        statement.executeUpdate("delete from profile");
        statement.executeUpdate("delete from cat");
        statement.executeQuery("select setval('profile_sequence', 1, false)");
        statement.executeQuery("select setval('cat_sequence', 1, false)");
        statement.executeQuery("select setval('vote_sequence', 1, false)");
    }

    private static void insertProfiles(Connection connection, Profile profile) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into profile values (nextval('profile_sequence'),?,?)");
        preparedStatement.setString(1, profile.name);
        preparedStatement.setString(2, profile.password);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void insertCats(Connection connection, Cat cat) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into cat values (nextval('cat_sequence'),?,?)");
        preparedStatement.setString(1, cat.name);
        preparedStatement.setString(2, cat.photo);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static List<Profile> getProfiles(){
        return List.of(
                new Profile("CatLover3000", "password"),
                new Profile("CatsIsMyLife", "password"),
                new Profile("Cats!!!", "password"));
    }

    private static List<Cat> getCats(){
        return List.of(
                new Cat("Kitty2020", PHOTO_PATH + "1.jpg"),
                new Cat("EpicVakCoronaKitty", PHOTO_PATH + "2.jpg"),
                new Cat("MisKitty2021", PHOTO_PATH + "3.jpg"),
                new Cat("SandersKitty19", PHOTO_PATH + "4.jpg"),
                new Cat("DecemberKitty", PHOTO_PATH + "5.jpg"),
                new Cat("MiMiMiKitty", PHOTO_PATH + "6.jpg"),
                new Cat("SarsKitty", PHOTO_PATH + "7.jpg"),
                new Cat("Melany", PHOTO_PATH + "8.jpg"),
                new Cat("JavaKitty", PHOTO_PATH + "9.jpg"),
                new Cat("SomePHPKitty", PHOTO_PATH + "10.jpg"));
    }

    private static final class Profile {
        private final String name;
        private final String password;

        public Profile(String name, String password) {
            this.name = name;
            this.password = password;
        }

        @Override
        public java.lang.String toString() {
            return "Profile{" + "name='" + name + '\'' + ", password='" + password + '}';
        }
    }

    private static final class Cat {
        private final String name;
        private final String photo;

        public Cat(String name, String photo) {
            this.name = name;
            this.photo = photo;
        }

        @Override
        public java.lang.String toString() {
            return "Cat{" + "name='" + name + '\'' + ", img='" + photo + '}';
        }
    }

}