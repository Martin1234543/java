import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class FoodProduct extends Product{
    Double[] prices;
    String[] name;

    public FoodProduct(Double[] prices, String[] name) {
        this.prices = prices;
        this.name = name;
    }

    public FoodProduct(Double[] prices, String name) {
        this.prices = prices;
        this.name = new String[]{name};
    }

    public FoodProduct(Double[] prices) {
        this.prices = prices;
    }

//    public static FoodProduct fromCsv(Path path, String province) throws IOException {
//        String name;
//        Double[] prices;
//
//        String line;
//        Scanner scanner = new Scanner(path);
//        name= scanner.next();
//        scanner.nextLine();
//
//        line= scanner.nextLine();
//        String[] fields=line.split(";");
//        while (scanner.hasNext()){
//            if(Objects.equals(fields[0], province)){
//                prices = Arrays.stream(scanner.next().split(";")) // odczytuję kolejną linię i dzielę ją na tablicę
//                        .map(value -> value.replace(",",".")) // zamieniam polski znak ułamka dziesiętnego - przecinek na kropkę
//                        .map(Double::valueOf) // konwertuję string na double
//                        .toArray(Double[]::new); // dodaję je do nowo utworzonej tablicy
//
//                scanner.close();
//            }
//        }
//
//        try {
//             // odczytuję pierwszą linię i zapisuję ją jako nazwa
//            //String line;
//            scanner.nextLine();  // pomijam drugą linię z nagłówkiem tabeli
//            while(scanner.hasNext()){
//               line= scanner.nextLine();
//               if (line.contains(province)){
//
//               }
//            }
//
//
//            return new FoodProduct(prices, province);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
public static FoodProduct fromCsv(Path path, String province) throws IOException {
    String name;
    Double[] prices;
 try (Scanner scanner = new Scanner(path)) {
        // Odczytaj nazwę produktu.
        name = scanner.nextLine();

        // Pomijam drugą linię z nagłówkiem tabeli.
        scanner.nextLine();

        // Pętla po kolejnych liniach pliku.
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            // Sprawdź, czy linia zawiera dane dla określonej prowincji.
            if (Objects.equals(line.split(";")[0], province)) {
                // Odczytaj ceny z linii.
                prices = Arrays.stream(line.split(";"))
                        .map(value -> value.replace(",", "."))
                        .map(Double::valueOf)
                        .toArray(Double[]::new);

                // Zwróć obiekt FoodProduct.
                return new FoodProduct(prices, province);
            }
        }
    }

    // Nie znaleziono danych dla określonej prowincji.
        throw new RuntimeException("Nie znaleziono danych dla określonej prowincji.");
}

    public double getPrice(int year, int month, String province) {
        if (month>12||(year<2010)||(month>4&&year>2022)){
            throw new IndexOutOfBoundsException();
        }
         int index =(year-2010)*12+month-1;
         return prices[index];
    }

    @Override
    public double getPrice(int year, int month) {
        return 0;
    }
}
