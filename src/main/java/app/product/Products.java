package app.product;
//
import lombok.*;
//
@Value
public class Products {
    public Products(String ID, String info, String image, String name, String price, String category) {
        this.ID = ID;
        this.info = info;
        this.image = image;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    String ID;
    String info;
    String image;
    String name;
    String price;
    String category;

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

    public String getID() {
        return ID;
    }
}
