package model;

public class User {
    public int id;
    public String name;
    public String password;
    public String phone;
    public int designation;
    public String address;
    public User(int id, String name, String password, String phone, int designation,String address)
    {
        this.id =id;
        this.name =name;
        this.password =password;
        this.phone =phone;
        this.designation =designation;
        this.address =address;
    }
}
