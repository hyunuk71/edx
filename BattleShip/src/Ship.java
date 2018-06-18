public class Ship {
    private int x;
    private int y;
    boolean isLive;

    public Ship() {
        this.x = 99;
        this.y = 99;
        this.isLive = true;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
