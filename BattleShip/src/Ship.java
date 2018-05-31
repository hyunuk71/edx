public class Ship {
    private int x;
    private int y;
    boolean isLive;

    public Ship() {
        this.x = 0;
        this.y = 0;
        this.isLive = true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
