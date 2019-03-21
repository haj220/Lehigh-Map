import student.TestCase;

/**
 * @author parkerjiang
 * @version 2018.04.23
 */
public class BinaryNodeTest extends TestCase {
    
    private BinaryNode<Integer> d;
    private BinaryNode<Integer> e;
    private BinaryNode<Integer> f;

   
    /**
     * just a test
     */
    public void setUp() {
        
        d = new BinaryNode(1);
        e = new BinaryNode(2);
        f = new BinaryNode(3);
    }

    /**
     * a test class
     */
    public void testCompare() {
        
        d.setLeft(e);
        d.setRight(f);
        assertEquals(2, d.getLeft().getElement(), 1.0);
        assertEquals(3, d.getRight().getElement(), 1.0);

    }

}
