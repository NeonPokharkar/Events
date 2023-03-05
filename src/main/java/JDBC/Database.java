package JDBC;

import model.Booking;
import model.Product;
import model.User;
import model.Venue;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    public Connection connection;
    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "ShivBhakt@1");
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
    public void addEvent(String name,String description, String price) throws SQLException {
        String addUser="INSERT INTO Products (name, description, price) VALUES (?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(addUser);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,description);
        preparedStatement.setString(3,price);
        preparedStatement.execute();
    }
    public void addVenue(String name,String address) throws SQLException {
        String addUser="INSERT INTO Venues (name, address) VALUES (?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(addUser);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,address);
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
        String getUsers="SELECT id FROM Users WHERE name=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(getUsers);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }
    public int getProductId(String name) throws SQLException {
        String getUsers="SELECT id FROM Products WHERE name=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(getUsers);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }
    public int getVenueId(String name) throws SQLException {
        String getUsers="SELECT id FROM Venues WHERE name=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(getUsers);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }
    public int getUserDesignation(String name) throws SQLException {
        String getUsers="SELECT designation FROM Users WHERE name=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(getUsers);
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("designation");
    }
    public void deleteProduct(int id) throws SQLException {
        String deleteProduct="DELETE FROM Products WHERE id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(deleteProduct);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }
    public void deleteBooking(int id) throws SQLException {
        String deleteProduct="DELETE FROM Bookings WHERE id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(deleteProduct);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }
    public void deleteVenue(int id) throws SQLException {
        String deleteProduct="DELETE FROM Venues WHERE id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(deleteProduct);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }
    public ArrayList<Booking> getBookings() throws SQLException {
        String getBookings="SELECT Bookings.id AS id, Users.name AS user, Products.name AS product, Venues.name AS venue, Bookings.paymentmode AS paymentmode, Bookings.date AS date FROM Bookings INNER JOIN Users ON Bookings.userid=Users.id INNER JOIN Products ON Bookings.eventid=Products.id INNER JOIN Venues ON Bookings.venueid=Venues.id;";
        PreparedStatement preparedStatement=connection.prepareStatement(getBookings);
        ResultSet resultSet=preparedStatement.executeQuery();
        ArrayList<Booking> bookings=new ArrayList<>();
        while(resultSet.next())
        {
            Booking booking=new Booking();
            booking.setId(resultSet.getInt("id"));
            booking.setUser(resultSet.getString("user"));
            booking.setEvent(resultSet.getString("product"));
            booking.setVenue(resultSet.getString("venue"));
            int paymentMode=resultSet.getInt("paymentmode");
            if(paymentMode==0)
            {
                booking.setPaymentmode("Online");
            }
            else {
                booking.setPaymentmode("Offline");
            }
            booking.setDate(resultSet.getString("date"));
            bookings.add(booking);
        }
        return bookings;
    }
    public ArrayList<Booking> getBookingsName(String name) throws SQLException {
        int userid=getUserId(name);
        String getBookings="SELECT Bookings.id AS id, Users.name AS user, Products.name AS product, Venues.name AS venue, Bookings.paymentmode AS paymentmode, Bookings.date AS date FROM Bookings INNER JOIN Users ON Bookings.userid=Users.id INNER JOIN Products ON Bookings.eventid=Products.id INNER JOIN Venues ON Bookings.venueid=Venues.id WHERE Bookings.userid=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(getBookings);
        preparedStatement.setInt(1,userid);
        ResultSet resultSet=preparedStatement.executeQuery();
        ArrayList<Booking> bookings=new ArrayList<>();
        while(resultSet.next())
        {
            Booking booking=new Booking();
            booking.setId(resultSet.getInt("id"));
            booking.setUser(resultSet.getString("user"));
            booking.setEvent(resultSet.getString("product"));
            booking.setVenue(resultSet.getString("venue"));
            int paymentMode=resultSet.getInt("paymentmode");
            if(paymentMode==0)
            {
                booking.setPaymentmode("Online");
            }
            else {
                booking.setPaymentmode("Offline");
            }
            booking.setDate(resultSet.getString("date"));
            bookings.add(booking);
        }
        return bookings;
    }
    public void addBooking(String user, int eventid, int venueid, int paymentmode, String date) throws SQLException {
        int userid= getUserId(user);
        String addBooking="INSERT INTO Bookings (userid, eventid, venueid, paymentmode, date) VALUES (?,?,?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(addBooking);
        preparedStatement.setInt(1,userid);
        preparedStatement.setInt(2,eventid);
        preparedStatement.setInt(3,venueid);
        preparedStatement.setInt(4,paymentmode);
        preparedStatement.setString(5,date);
        preparedStatement.execute();
    }
}
