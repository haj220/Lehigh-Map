import java.util.ArrayList;

import student.TestCase;

/**
 * @author Aaron Rose
 * @author Vincent Albanese
 * @author Haonan Jiang
 * @version 2018.05.07
 * @param <T>
 */
public class NodeTest<T> extends TestCase {
    private Node<T> n;
    private Node<T> g;
    private Node<T> e;
    private Node<T> f;

    /**
     * setup
     * 
     * @param a
     *            a string list
     * @return the whole string
     */
    

    public void setUp() {
        Point a = new Point(3, 5);
        ArrayList<String> place = new ArrayList<String>();
        place.add("audihonda");
        n = new Node<T>(a, place);
        g = new Node<T>(a, place);
        e = new Node<T>(a, place);
        f = new Node<T>(a, place);
        
    }

    /**
     * test getpoint
     */
    public void testGetPoint() {
        assertEquals("(3, 5)", n.getPoint().toString());
    }

    /**
     * test setpoint
     */
    public void testSetPoint() {
        Point b = new Point(5, 8);
        n.setPoint(b);
        assertEquals("(5, 8)", n.getPoint().toString());
    }

    /**
     * test getplace
     */
    public void testGetPlace() {

        assertEquals("[audihonda]", n.getPlace().toString());
    }

    /**
     * test setplace
     */
    public void testSetPlace() {
        ArrayList<String> kkk = new ArrayList<String>();
        kkk.add("kiatoyota");
        n.setPlace(kkk);

        assertEquals("[kiatoyota]", n.getPlace().toString());
    }
    /**
     * 
     */
    public void testSetDistance() {
        n.setDistance(3.2);
        assertEquals(3.2,n.getDistance(),0.1);
    }
    /**
     * 
     */
    public void testSetStreet() {
        ArrayList<String> kkk = new ArrayList<String>();
        kkk.add("kiatoyota");
        n.setStreets(kkk);
        assertEquals("[kiatoyota]", n.getStreets().toString());
        
        
    }
    /**
     * 
     */
    public void testCompare() {
        n.setDistance(2.5);
        g.setDistance(2.5);
        e.setDistance(1.6);
        f.setDistance(3.5);
        assertEquals(0,n.compareTo(g));
        assertEquals(1,n.compareTo(e));
        assertEquals(-1,n.compareTo(f));
        
        
    }

    /**
     * test Tostring
     */
    public void testTo() {
        assertEquals("(3, 5)[audihonda]", n.toString());
    }
}
