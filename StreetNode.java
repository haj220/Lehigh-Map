import java.util.ArrayList;

/**
 * @author Aaron Rose
 * @author Vincent Albanese
 * @author Haonan Jiang
 * @version 2018.05.07
 *
 */
public class StreetNode implements Comparable<StreetNode> {
private String street;

private ArrayList<Node<Point>> place;
/**
 * @param street
 */
public StreetNode(String street) {
    this.street = street;
    place = new ArrayList<Node<Point>>();
}
/**
 * @return   O(1)
 */
public String getStreet() {
    return street;
}
/**
 * @param street O(1)
 */
public void setStreet(String street) {
    this.street = street;
}
/**
 * @return     O(1)
 */
public ArrayList<Node<Point>> getPlace() {
    return place;
}
/**
 * @param place    O(1)
 */
public void setPlace(ArrayList<Node<Point>> place) {
    this.place = place;
}
/**
 * @param  O(1)
 * @return
 */
public boolean addPoint(Node<Point> n) {
    this.place.add(n);
    return true;
}

/**
 * @
 * @return to string     O(1)
 */
public String toString() {
    return this.getPlace().toString();
}
/**
 * @param o
 * @return     O(1)
 */
public int compareTo(StreetNode o) {
    if(this.street.compareTo(o.street) > 0) {
        return 1;
    }
    if(this.street.compareTo(o.street) < 0) {
        return -1;
    }
    return 0;
    
}
}
