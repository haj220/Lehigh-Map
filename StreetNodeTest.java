import java.util.ArrayList;

import student.TestCase;
public class StreetNodeTest extends TestCase {
    private StreetNode a;
    private StreetNode b;
    private StreetNode c;
    private StreetNode d;
    private Node<Point> f;
    public void setUp() {
        a = new StreetNode("packer");
        b = new StreetNode("packer");
        c = new StreetNode("ball");
        d = new StreetNode("zebra");
        Point a = new Point(3, 5);
        ArrayList<String> place = new ArrayList<String>();
        place.add("audihonda");
        f = new Node<Point>(a, place);
    }
/**
 * 
 */
public void testCompare() {
    assertEquals(0, a.compareTo(b));
    assertEquals(1, a.compareTo(c));
    assertEquals(-1, a.compareTo(d));
}
/**
 * 
 */
public void testAdd() {
    ArrayList<Node<Point>> kkk = new ArrayList<Node<Point>>();
    kkk.add(f);
    a.setPlace(kkk);
    assertTrue(a.addPoint(f));
}
/**
 * 
 */
public void testToString() {
    ArrayList<Node<Point>> kkk = new ArrayList<Node<Point>>();
    kkk.add(f);
    a.setPlace(kkk);
    assertEquals("[(3, 5)[audihonda]]", a.toString());
}
/**
 * 
 */
public void testSetPlace() {
    ArrayList<Node<Point>> kkk = new ArrayList<Node<Point>>();
    kkk.add(f);
    a.setPlace(kkk);
    assertEquals("[(3, 5)[audihonda]]", a.toString());
}
/**
 * 
 */
public void testSetStreet() {
    a.setStreet("packer");
    assertEquals("packer", a.getStreet());
}
}
