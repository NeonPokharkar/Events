package model;

public class Product {
    public int id;
    public String name;
    public String description;
    public String price;
    public Product(int id, String name, String description, String price)
    {
        this.id =id;
        this.name =name;
        this.description =description;
        this.price =price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
