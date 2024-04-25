import java.util.List;
import java.util.Set;

public class City extends Polygon{
    public final Point center;
    private String name;
    private boolean isPort;

    public void setPort(boolean port) {
        isPort = port;
    }

    public City(String name, double length, Land land){
     super(List.of(new Point(length/2, length/2), new Point(-length/2, length/2), new Point(length/2, -length/2), new Point(-length/2, -length/2)));
     this.name=name;
     this.center=new Point(0,0);
     this.isPort=isPort(this, land);

 }
    public boolean isPort(City city, Land land){
        if(land.inside(city.center)){
            return true;
        }
        return false;
    }
    private Set<Resource.Type> resources;
    public void addResourcesInRange(List<Resource> resourceList, double range){
        for (Resource resource: resourceList){
            if(resource.getA().distance(center)<=range){
                if(resource.getType()==Resource.Type.Fish && !isPort){
                    continue;
                }
                this.resources.add(resource.getType());
            }
        }
    }

    public String getName() {
        return name;
    }
}
