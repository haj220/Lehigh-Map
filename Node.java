import java.util.ArrayList;

/**
 * @author Aaron Rose
 * @author Vincent Albanese
 * @author Haonan Jiang
 * @version 2018.05.07
 * 
 * @param <T>
 */
public class Node<T>  implements Comparable<Node<T>>{
    private Point a;
    
    private ArrayList<String> place;
    private ArrayList<String> streets;
    

    private double distance;

    /**
     * @param a
     *            a point parameter
     * @param list
     *            the string array
     */
    public Node(Point a, ArrayList<String> list) {
        this.a = a;
        this.place = list;
        this.distance = 0;
        this.streets = null;
    }

    /**
     * @return the point O(1)
     */
    public Point getPoint() {
        return a;
    }

    /**
     * @param b
     *            the desired point O(1)
     */
    public void setPoint(Point b) {
        this.a = b;

    }

    /**
     * @return the place coor. O(1)
     */
    public ArrayList<String> getPlace() {
        return this.place;
    }

    /**
     * @param p
     *            desired place O(1)
     */
    public void setPlace(ArrayList<String> p) {

        this.place = p;

    }
    /**
     * @return O(1)
     */
    public ArrayList<String> getStreets() {
        return streets;
    }

    /**
     * @param streets O(1)
     */
    public void setStreets(ArrayList<String> streets) {
        this.streets = streets;
    }

    /**
     * @return   O(1)
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance       O(1)
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
    

    /**
     * @return printed string O(1)
     */
    public String toString() {
        return a.toString() + this.place.toString();
    }

    /**
     * @param o
     * @return     O(1)
     */
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Node<T> o) {
        if(this.distance > o.distance) {
            return 1;
        }
        if(this.distance < o.distance) {
            return -1;
        }
        return 0;
    }
    // create new arrayList that will hold the Nodes that are being pulled
    // out of the MinHeap
    //ArrayList<Node<Point>> secondList = new ArrayList<Node<Point>>();
    //while(minHeap.heapsize() > 0) {
        //secondList.add((Node)minHeap.removemin());
   //}
    
    //ArrayList<Node<Point>> thirdList = new ArrayList();
    
    //thirdList.addAll((Collection<? extends Node<Point>>) secondList);
    //return secondList;

}