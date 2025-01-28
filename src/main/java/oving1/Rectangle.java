package oving1;

public class Rectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    int getMinX() {
        if ( x1 > x2 ) {
            return x2;
        } else {
            return x1;
        }
    }

    int getMinY() {
        if ( y1 > y2 ) {
            return y2;
        } else {
            return y1;
        }
    }

    int getMaxY() {
        if ( y1 > y2 ) {
            return y1;
        } else {
            return y2;
        }
    }

    int getMaxX() {
        if ( x1 > x2 ) {
            return x1;
        } else {
            return x2;
        }
    }

    int getWidth() {
        return Math.abs(x1 - x2);
    }

    int getHeight() {
        return Math.abs(y1 - y2);
    }

    boolean isEmpty() {
        if ( x1 == x2 || y1 == y2 ) {
            return true;
        }
        return false;
    }

    boolean contains(int x, int y) {
        if ( (this.getMinX() <= x && x <= this.getMaxX()) && this.getMinY() <= y && y <= this.getMaxY()) {
            return true;
        }
        return false;
    }

    boolean contains(Rectangle rect) {
        if (rect.getMinX() >= this.getMinX() && rect.getMaxX() <= this.getMaxX() && rect.getMinY() >= this.getMinY()
                && rect.getMaxY() <= this.getMaxY()) {
            return true;
        }
        return false;
    }

    boolean add(int x, int y) {
        if (contains(x, y)) {
            return false;
        }
        this.x1 = x;
        this.y1 = y;
        return true;

    }

    boolean add(Rectangle rect) {
        if (contains(rect) || rect.isEmpty()) {
            return false;
        }
        
        boolean changed = false;

        if (rect.getMinX() < this.getMinX()) {
            this.x1 = rect.getMinX();
            changed = true;
        }

        if (rect.getMaxX() > this.getMaxX()) {
            this.x2 = rect.getMaxX();
            changed = true;
        }

        if (rect.getMinY() < this.getMinY()) {
            this.y1 = rect.getMinY();
            changed = true;
        }

        if (rect.getMaxY() > this.getMaxY()) {
            this.y2 = rect.getMaxY();
            changed = true;
        }

        return changed;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(13, -27, -11, 23);
        Rectangle rect = new Rectangle(1, 0, 3, 1);
        System.out.println(rectangle.contains(4, 1));
        System.out.println("Rektangel: " + "(" + rectangle.getMinX() + "," + rectangle.getMinY()
                + ")" + " og " + "(" + rectangle.getMaxX() + "," + rectangle.getMaxY() + ")");
        System.out.println("Rect     : " + "(" + rect.getMinX() + "," + rect.getMinY() + ")" + " og " + "(" + rect.getMaxX() + "," + rect.getMaxY() + ")");
        System.out.println(rectangle.add(15, 33));
    }
}

