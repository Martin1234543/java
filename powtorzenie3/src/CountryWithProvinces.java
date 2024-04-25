import java.time.LocalDate;
import java.util.List;

public class CountryWithProvinces extends Country{
    public static Country[] countries;
    public static List<LocalDate> date;
    public static List<Integer> deaths;
    public static List<Integer> infections;

    public CountryWithProvinces(String name, Country[] countries) {
        super(name);
        this.countries = countries;
    }
    public void addDateStatistic(LocalDate date, int infect, int death){
        this.date.add(date);
        this.infections.add(infect);
        this.deaths.add(death);
    }

    public CountryWithProvinces(String name) {
        super(name);
    }

}
