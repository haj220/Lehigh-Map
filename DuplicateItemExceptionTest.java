


import student.TestCase;

/**
 * @author parkerjiang
 * @version 2018.04.23
 */
public class DuplicateItemExceptionTest extends TestCase {
    private BinarySearchTree<String> tree;

    
    /**
     * just a test
     */
    
    public void setUp() {
        tree = new BinarySearchTree();
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

}
