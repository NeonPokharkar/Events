package JDBC;

import model.Product;
import model.User;
import model.Venue;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    public Connection connection;
    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "TeriMaKaLundBc@1");
        if(connection==null)
        {
            throw new Exception("Connection failed");
        }
        createTables();
    }
    public void createTables() throws SQLException {
        String createUsers= "CREATE TABLE IF NOT EXISTS Users (id INTEGER(255) AUTO_INCREMENT, name VARCHAR(100), password VARCHAR(100), designation INTEGER(2), phone VARCHAR(100), address VARCHAR(100), PRIMARY KEY (id));";
        String createVenues="CREATE TABLE IF NOT EXISTS Venues (id INTEGER(255) AUTO_INCREMENT, name VARCHAR(100), address VARCHAR(100), PRIMARY KEY (id));";
        String createBookings="CREATE TABLE IF NOT EXISTS Bookings (id INTEGER(255) AUTO_INCREMENT, userid INTEGER(100), eventid INTEGER(255), venueid INTEGER(255), paymentmode INTEGER(2), date DATE, PRIMARY KEY (id), FOREIGN KEY (eventid) REFERENCES Products(id), FOREIGN KEY (venueid) REFERENCES Venues(id), FOREIGN KEY (userid) REFERENCES Users(id));";
        String createEvents="CREATE TABLE IF NOT EXISTS Products (id INTEGER(255) AUTO_INCREMENT, name VARCHAR(100), `description` VARCHAR(100), price VARCHAR(100), PRIMARY KEY (id));";
        PreparedStatement preparedStatement=connection.prepareStatement(createUsers);
        preparedStatement.execute();
        preparedStatement=connection.prepareStatement(createEvents);
        preparedStatement.execute();
        preparedStatement=connection.prepareStatement(createVenues);
        preparedStatement.execute();
        preparedStatement=connection.prepareStatement(createBookings);
        preparedStatement.execute();
    }
    public void addUser(String name,String pass, int design,String phone, String address) throws SQLException {
        String addUser="INSERT INTO Users (name, password, designation, phone, address) VALUES (?,?,?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(addUser);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pass);
        preparedStatement.setInt(3,design);
        preparedStatement.setString(4,phone);
        preparedStatement.setString(5,address);
        preparedStatement.execute();
    }
    public ArrayList<User> getUsers() throws SQLException {
        String getUsers="SELECT * FROM Users;";
        PreparedStatement preparedStatement=connection.prepareStatement(getUsers);
        ResultSet resultSet=preparedStatement.executeQuery();
        ArrayList<User> users=new ArrayList<>();
        while(resultSet.next())
        {
            User user=new User(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("password"),resultSet.getString("phone"),resultSet.getInt("designation"),resultSet.getString("address"));
            users.add(user);
        }
        return users;
    }
    public ArrayList<Product> getProducts() throws SQLException {
        String getProducts="SELECT * FROM Products;";
        PreparedStatement preparedStatement=connection.prepareStatement(getProducts);
        ResultSet resultSet=preparedStatement.executeQuery();
        ArrayList<Product> products=new ArrayList<>();
        while(resultSet.next())
        {
            Product product=new Product(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("description"),resultSet.getString("price"));
            products.add(product);
        }
        return products;
    }
    public ArrayList<Venue> getVenues() throws SQLException {
        String getVenues="SELECT * FROM Venues;";
        PreparedStatement preparedStatement=connection.prepareStatement(getVenues);
        ResultSet resultSet=preparedStatement.executeQuery();
        ArrayList<Venue> venues=new ArrayList<>();
        while(resultSet.next())
        {
            Venue venue=new Venue(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("address"));
            venues.add(venue);
        }
        return venues;
    }
    public String getUserPassword(String name) throws SQLException {
        String getUsers="SELECT password FROM Users WHERE name=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(getUsers);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("password");
    }
    public int getUserId(String name) throws SQLException {
        String getUsers="SELECT password FROM Users WHERE name=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(getUsers);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }

}
