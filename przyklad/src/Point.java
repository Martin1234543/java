import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    public final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distance(Point point){
        return (sqrt(pow(this.x- point.x, 2))+sqrt(pow( this.y- point.y, 2)));
    }
}
