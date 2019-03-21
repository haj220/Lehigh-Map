/**
 * Contributions: Worked on all methods together, everyone contributed equally
 * 
 * Test class for the Quad Class
 * 
 * @author Aaron Rose
 * @author Vincent Albanese
 * @author Haonan Jiang
 * @version 2018.05.7
 * 
 * 
 *
 */
public class QuadTest extends student.TestCase {
    private Quad a;

    private Point top;
    private Point bot;

    /**
     * set up Quads
     */
    public void setUp() {
        top = new Point(0, 0);
        bot = new Point(4, 4);
        a = new Quad(top, bot);

    }

    /**
     * test insert method
     */
    public void testInsert() {
        top = new Point(0, 0);
        bot = new Point(3, 3);
        a = new Quad(top, bot);
        Point p = new Point(1, 1);

        assertTrue(a.inTheBound(p));

        a.insert(1, 2, "for");
        a.insert(1, 3, "for");

        a.insert(2, 3, "for");
        a.insert(2, 1, "bank");
        a.insert(2, 2, "school");
        a.insert(2, 2, "for");
        //assertNull(a.search(10, 0));
        a.insert(null);
        assertEquals("[]", a.search("lol").toString());

        // a.insert(null);

        assertEquals("[for]", a.search(1, 2).getPlace().toString());
        assertEquals("[for]", a.search(1, 3).getPlace().toString());
        assertEquals("[school, for]", a.search(2, 2).getPlace().toString());
        assertEquals("[bank]", a.search(2, 1).getPlace().toString());
        assertEquals("[(2, 2)[school, for]]", a.search("school").toString());

        assertNull(a.search(10, 10));

        assertEquals("[(2, 1)[bank]]",a.search("bank").toString());

        a.insert(null);
        assertEquals("[(1, 3)[for], (1, 2)[for], (2, 3)[for], (2, 2)[school, for]]",
            a.search("for").toString());
    }

    /**
     * test search method
     */
    public void testSearch() {
        a.insert(1, 1, "first");

    }
    
    /**
     * test improved insert method
     */
    public void testImprovedInsertAndSearch() {
        a.insert(1, 1, "bank", "first", "second", "third");
        a.insert(10, 10 ,"bank", "first", "second", "third");
        a.insert(1, 1 ,"school", "first", "second", "third");
        a.insert(3, 3, "bank", "first");
        
        assertTrue(systemOut().getHistory().contains("out of bound"));
        
        assertEquals(a.streetSearch("first", "bank").toString(), "[(1, 1)[bank], (3, 3)[bank]]");
        assertEquals(a.streetSearch("first", "school").toString(), "[(1, 1)[school]]");
        
        assertNull(a.streetSearch(null,null));
        a.streetSearch(null);
        assertTrue(systemOut().getHistory().contains("string is null"));
        a.insert(1, 1, "bank", "first", "second", "third");
        //assertTrue(systemOut().getHistory().contains("it exists"));
        
    }
    /**
     * tester for the street search
     */
    public void testStreetSearch() {
        a.insert(3, 3, "bank", "first");
        a.insert(2, 2, "bank", "first");
        a.insert(1, 2, "bank", "first");
        a.streetSearch("first");
        assertTrue(systemOut().getHistory().contains("[(3, 3)[bank], (2, 2)[bank], (1, 2)[bank]]"));
        a.insert(2, 3, "school", "first");
        a.insert(3, 1, "bank", "second");
        assertEquals("[(1, 2)[bank], (2, 2)[bank], (3, 3)[bank]]",
            a.streetSearch(1, 1, "first", "bank").toString());     
        assertNull(a.streetSearch(10, 10, "bank", "first"));
        assertNull(a.streetSearch(1, 1, null, null));

        
    }
    

}