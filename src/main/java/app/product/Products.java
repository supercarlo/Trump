package app.product;

import lombok.*;

@Value
public class Products {
    String ID;
    String info;
    String image;
    String name;
    String price;
    String category;

    public String getID() {
        return ID;
    }

    public String getInfo() {
        return info;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
