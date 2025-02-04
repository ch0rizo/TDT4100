package oving1;

public class Location {
    private int x = 0;
    private int y = 0;

    public Location() {
        this.x = 0;
        this.y = 0;
    }

    public void up() {
        this.y--;
    }

    public void down() {
        this.y++;
    }

    public void left() {
        this.x--;
    }

    public void right() {
        this.x++;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Your Location: (" + this.getX() + "," + this.getY()  + ")";
    }

    public static void main(String[] args) {
        Location location = new Location();
        location.right();
        location.down();
        location.down();
        location.down();
        System.out.println(location.toString());
    }
}
