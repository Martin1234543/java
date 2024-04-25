public class Resource {
    public enum Type{
        Coal, Wood, Fish
    }
    public final Point a;
    public final Type type;

    public Resource(Point a, Type type) {
        this.a = a;
        this.type = type;
    }

    public Point getA() {
        return a;
    }

    public Type getType() {
        return type;
    }
}
