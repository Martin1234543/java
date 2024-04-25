import java.util.List;

public abstract class Product {
    private String name;
    private static List<Product> productList;

    public String getName() {
        return name;
    }
    public abstract double getPrice(int year, int month);
}
