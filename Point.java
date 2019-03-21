/**
 * @author Aaron Rose
 * @author Vincent Albanese
 * @author Haonan Jiang
 * @version 2018.05.07
 * 
 */
public class Point {
    private int x;
    private int y;

    /**
     * @param x
     *            x coor
     * @param y
     *            y coor
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x value O(1)
     */
    public int getX() {
        return this.x;
    }

    /**
     * @param x
     *            x coordinate x coor O(1)
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y value O(1)
     */
    public int getY() {
        return this.y;
    }

    /**
     * @param y
     *            set y O(1)
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return content of point O(1)
     */
    public String toString() {
        return "(" + Integer.toString(this.getX()) + ", " + Integer.toString(this.getY()) + ")";
    }

    /**
     * @return if equal or not O(1) null check type check
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Point)
            if ((this.getX() == ((Point) o).getX()) && (this.getY() == ((Point) o).getY())) {
                return true;
            }
        return false;
    }
}