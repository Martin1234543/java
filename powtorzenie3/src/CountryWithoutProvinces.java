import java.time.LocalDate;
import java.util.List;

public class CountryWithoutProvinces extends Country{
    public List<LocalDate> date;
    public List<Integer> deaths, infections;

    public CountryWithoutProvinces(String name) {
        super(name);
    }

    public void addDateStatistic(LocalDate date, int infect, int death){
        this.date.add(date);
        this.infections.add(infect);
        this.deaths.add(death);
    }
}
