import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private List<Point> arr = new ArrayList<>();

    public Polygon(List<Point> arr) {
        this.arr = arr;
    }
    public boolean inside(Point point){
        int counter=0;
        Point pa, pb;
        Point tmp;
        double d, x, a, b;
        for (int i = 0; i < arr.size()-1; i++) {
            pa= arr.get(i);
            pb=arr.get(i+1);
            if (pa.y>pb.y){
                tmp = pa;
                pa= pb;
                pb = tmp;
            }
            if(pa.y < point.y&&point.y < pb.y){
                d=pb.x-pa.x;
                if(d==0){
                    x=pa.x;
                }
                else{
                    a = (pb.y - pa.y) / d;
                    b = pa.y - a * pa.x;
                    x = (point.y - b) / a;
                }
                if (x< point.x){
                    counter++;
                }
            }
        }
        return counter % 2 == 1;
    }
}
