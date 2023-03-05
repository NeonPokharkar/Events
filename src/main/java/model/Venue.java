package model;

public class Venue {
    public int id;
    public String name;
    public String address;
    public Venue(int id, String name, String address){
        this.id =id;
        this.name =name;
        this.address =address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
