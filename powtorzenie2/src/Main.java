import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
//        NonFoodProduct product=NonFoodProduct.fromCsv(Path.of("C:\\Users\\marti\\powtorzenie2\\src\\nic"));
        FoodProduct foodProduct = FoodProduct.fromCsv(Path.of("C:\\Users\\marti\\powtorzenie2\\src\\buraki.csv"), "OPOLSKIE");
      // System.out.println(foodProduct.getPrice(2010, 1));
//        System.out.println(product.getPrice(2010, 1));
//        System.out.println();
        try {
            foodProduct.getPrice(2010,4);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}