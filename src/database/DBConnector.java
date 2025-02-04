package database;

import jdk.jfr.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/blog_task_final",
                    "postgres", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static Users getUser (String email){
        Users user = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM users WHERE email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getString("role_id"));

            }
            resultSet.close();
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<NewsCategories> getCategories (){
        List<NewsCategories> categories = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM news_categories");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories = new ArrayList<>();
                NewsCategories category = new NewsCategories();

                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));

                categories.add(category);


            }

            resultSet.close();
            return categories;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
