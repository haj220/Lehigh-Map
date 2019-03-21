import student.TestCase;

/**
 * @author parkerjiang
 * @version 2018.04.23
 */
public class ContactTest extends TestCase {
    private Contact a;
    private Contact b;
    private Contact c;
    private BinaryNode<Integer> d;
    private BinaryNode<Integer> e;
    private BinaryNode<Integer> f;

   
    /**
     * just a test
     */
    public void setUp() {
        a = new Contact("a", "b", "0");
        b = new Contact("a", "b", "0");
        c = new Contact("a", "b", "1");
        d = new BinaryNode(1);
        e = new BinaryNode(2);
        f = new BinaryNode(3);
    }

    /**
     * a test class
     */
    public void testCompare() {
        assertEquals(0, a.compareTo(b));
        assertEquals(1, a.compareTo(c));
        d.setLeft(e);
        d.setRight(f);
        assertEquals(2, d.getLeft().getElement(), 1.0);
        assertEquals(3, d.getRight().getElement(), 1.0);

    }

}
