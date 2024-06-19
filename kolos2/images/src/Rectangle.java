
public class Rectangle {

    private int x;
    private int y;
    private int szerokość;
    private int wysokość;
    private String kolor;

    public Rectangle(int x, int y, int szerokość, int wysokość, String kolor) {
        this.x = x;
        this.y = y;
        this.szerokość = szerokość;
        this.wysokość = wysokość;
        this.kolor = kolor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSzerokość() {
        return szerokość;
    }

    public void setSzerokość(int szerokość) {
        this.szerokość = szerokość;
    }

    public int getWysokość() {
        return wysokość;
    }

    public void setWysokość(int wysokość) {
        this.wysokość = wysokość;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }
}