import java.util.List;

public class Land extends Polygon{
    private List<City> cities= null;
    public Land(List<Point> arr) {
        super(arr);
    }
    public void addCities(City city){
    if(!inside(city.center)){
        throw new RuntimeException(city.getName());
    }
    cities.add(city);


    }

}
