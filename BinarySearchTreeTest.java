

import student.TestCase;

/**
 * @author parkerjiang
 * @version 2018.04.23
 */
public class BinarySearchTreeTest extends TestCase {
    private BinarySearchTree<String> tree;

    
    /**
     * just a test
     */
    
    public void setUp() {
        tree = new BinarySearchTree();
    }

    /**
     * just a test
     */
    public void testInsert() {
        assertTrue(tree.isEmpty());
        tree.insert("a");
        assertFalse(tree.isEmpty());

        tree.remove("a");
        assertTrue(tree.isEmpty());
        assertNull(tree.findMax());
        assertNull(tree.findMin());
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");
        tree.insert("e");
        tree.insert("f");
        assertEquals("b", tree.find("b"));
        tree.remove("d");
        assertNull(tree.find("d"));
        tree.remove("b");
        tree.remove("c");
        tree.remove("e");
        
        

        assertFalse(tree.isEmpty());
        assertEquals("f", tree.findMax());
        assertEquals("a", tree.findMin());
        tree.makeEmpty();
        assertTrue(tree.isEmpty());

    }
    /**
     * just a mdzz
     */
    public void testWebcat() {
        
        
        
        tree.insert("a");
        Exception thrown = null;
        try {
            tree.insert("a");
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof DuplicateItemException);
        
        Exception thrownn = null;
        try {
            tree.remove("z");
        } 
        catch (Exception exception) {
            thrownn = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrownn instanceof ItemNotFoundException);
        
        
    }
    /**
     * just a test
     */
    public void testExp() {
        ItemNotFoundException kkk = new ItemNotFoundException();
        assertNotNull(kkk);
        kkk = new ItemNotFoundException("gpa cannot lower 2.0");
        assertNotNull(kkk);
        DuplicateItemException mdzz = new DuplicateItemException();
        assertNotNull(mdzz);
        mdzz = new DuplicateItemException("gpa cannot lower 2.0");
        assertNotNull(mdzz);
    }
    /**
     * just a test
     */
    public void testInsertt() {
        tree.insert("g");
        tree.insert("d");
        tree.insert("y");
        tree.insert("app");
        tree.insert("zebra");
        tree.insert("090");
        assertNotNull(tree);
        
    }
    /**
     * just a test
     */
    public void testRemove() {
        tree.insert("g");
        tree.insert("d");
        tree.insert("y");
        tree.insert("app");
        tree.insert("zebra");
        tree.insert("090");
        tree.remove("app");
        assertEquals("090", tree.findMin());
        tree.remove("g");
        tree.remove("090");
        assertEquals("d", tree.findMin());
        tree.remove("y");
        tree.remove("d");
        assertEquals("zebra", tree.findMin());
        tree.remove("zebra");
        assertNull(tree.findMin());
        assertTrue(tree.isEmpty());
        tree.insert("a");
        tree.insert("bb");
        assertEquals("bb", tree.findMax());
        
        
        
    }
    

}
