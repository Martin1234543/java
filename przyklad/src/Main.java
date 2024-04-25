import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        boolean check;
        Land land = new Land(List.of(new Point(1, 1), new Point(-1, 1), new Point(1, -1), new Point(-1, -1)));
        try {
            land.addCities(new City("Pomznan", 1, land));

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}