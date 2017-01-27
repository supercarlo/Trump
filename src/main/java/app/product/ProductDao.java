package app.product;

        import app.DBC;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.*;

public class ProductDao {
    Products p;
    DBC dbc = new DBC();
    Statement stat = dbc.Connection();

    public List<Products> products = new ArrayList<>();

    public void addAllProducts() {
        try {
            String query = ("select productid, info, image, nameproduct, price, categoryname from product");
            stat.getConnection().commit();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                products.add(new Products(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public Iterable<Products> getAllProducts() {
        products.clear();
        addAllProducts();
        return products;
    }

    public Products getProductByID(String id) {
        if (id == null) {
            p = null;
        }else if (products.iterator().hasNext()) {
            p = products.get(Integer.valueOf(id)-1);
        } else if (!products.iterator().hasNext()) {
            p = products.get(products.size() - 1);
        }
        return p;
    }
}
