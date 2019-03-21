import java.util.ArrayList;
import java.util.Collection;

/**
 * Contributions: Worked on all methods together, everyone contributed equally
 * 
 * @author Aaron Rose
 * @author Vincent Albanese
 * @author Haonan Jiang
 * @version 2018.05.07
 * 
 * 
 */
public class Quad {
    private Point topLeft;
    private Point botRight;
    private Node<Point> node;
    private Quad topLeftTree;
    private Quad topRightTree;
    private Quad botLeftTree;
    private Quad botRightTree;
    private BinarySearchTree<StreetNode> tree;

    /**
     * @param topLeft
     *            the topLeft point
     * @param botRight
     *            the botRight point
     */
    public Quad(Point topLeft, Point botRight) {
        this.topLeft = topLeft;
        this.botRight = botRight;
        this.node = null;
        this.topLeftTree = null;
        this.botRightTree = null;
        this.topRightTree = null;
        this.botLeftTree = null;
        tree = new BinarySearchTree<StreetNode>();
    }

    /**
     * @param a
     *            another point
     * @return whether in the bound or not O(1)
     */
    public boolean inTheBound(Point a) {
        return ((a.getX() > topLeft.getX()) && (a.getX() <= botRight.getX())
                && (a.getY() > topLeft.getY())
                && (a.getY() <= botRight.getY()));
    }

    /**
     * @param x
     *            the x value of the point
     * @param y
     *            the y value of the point
     * @param description
     *            the description of the point O(log(n))
     */
    public void insert(int x, int y, String description) {
        Point a = new Point(x, y);
        ArrayList<String> list = new ArrayList<String>();
        list.add(description);
        Node<Point> temp = new Node<Point>(a, list);
        insert(temp);
    }

    /**
     * @param newNode
     *            the point to be insert
     *            
     *            body of method is O()
     */
    public void insert(Node<Point> newNode) {
        if (newNode == null) {

            return;
        }
        if (!inTheBound(newNode.getPoint())) {

            return;

        }
        if (Math.abs(topLeft.getX() - botRight.getX()) == 1
                && Math.abs(topLeft.getY() - botRight.getY()) == 1) {

            if (this.node == null) {
                this.node = newNode;

                return;

            }
            else {

                node.getPlace().addAll(newNode.getPlace());
                return;

            }

        }
        if (((topLeft.getX() + botRight.getX()) / 2 >= newNode.getPoint()
                .getX())
                && ((topLeft.getY() + botRight.getY()) / 2 >= newNode.getPoint()
                        .getY())) {

            if (topLeftTree == null) {
                Point b1 = new Point(topLeft.getX(), topLeft.getY());
                Point b2 = new Point((topLeft.getX() + botRight.getX()) / 2,
                        (topLeft.getY() + botRight.getY()) / 2);
                Quad newQ = new Quad(b1, b2);
                topLeftTree = newQ;
            }
            topLeftTree.insert(newNode);
        }
        if (((topLeft.getX() + botRight.getX()) / 2 >= newNode.getPoint()
                .getX())
                && ((topLeft.getY() + botRight.getY()) / 2 < newNode.getPoint()
                        .getY())) {

            if (botLeftTree == null) {
                Point b1 = new Point(topLeft.getX(),
                        (topLeft.getY() + botRight.getY()) / 2);
                Point b2 = new Point((topLeft.getX() + botRight.getX()) / 2,
                        botRight.getY());
                Quad newQ = new Quad(b1, b2);
                botLeftTree = newQ;
            }
            botLeftTree.insert(newNode);
        }
        if (((topLeft.getX() + botRight.getX()) / 2 < newNode.getPoint().getX())
                && ((topLeft.getY() + botRight.getY()) / 2 >= newNode.getPoint()
                        .getY())) {

            if (topRightTree == null) {
                Point b1 = new Point((topLeft.getX() + botRight.getX()) / 2,
                        topLeft.getY());
                Point b2 = new Point(botRight.getX(),
                        (topLeft.getY() + botRight.getY()) / 2);
                Quad newQ = new Quad(b1, b2);
                topRightTree = newQ;
            }
            topRightTree.insert(newNode);
        }
        if (((topLeft.getX() + botRight.getX()) / 2 < newNode.getPoint().getX())
                && ((topLeft.getY() + botRight.getY()) / 2 < newNode.getPoint()
                        .getY())) {

            if (botRightTree == null) {
                Point b1 = new Point((topLeft.getX() + botRight.getX()) / 2,
                        (topLeft.getY() + botRight.getY()) / 2);
                Point b2 = new Point(botRight.getX(), botRight.getY());
                Quad newQ = new Quad(b1, b2);
                botRightTree = newQ;
            }
            botRightTree.insert(newNode);
        }

    }

    /**
     * @param x
     *            x coor
     * @param y
     *            y coor
     * @return the node search for O(logn)
     */
    public Node<Point> search(int x, int y) {
        Point a = new Point(x, y);

        return search(a);

    }

    /**
     * @param p
     *            the point search for
     * @return a node
     */
    public Node<Point> search(Point p) {
        // base case:
        if (!inTheBound(p)) {

            return null;
        }
        if (this.node != null && Math.abs(topLeft.getX() - botRight.getX()) <= 1
                && Math.abs(topLeft.getY() - botRight.getY()) <= 1) {

            return node;
        }
        // recursive calls:
        if ((topLeft.getX() + botRight.getX()) / 2 >= p.getX()
                && (topLeft.getY() + botRight.getY()) / 2 >= p.getY()) {

            if (topLeftTree == null) {
                return null;
            }
            else {
                return topLeftTree.search(p);
            }
        }
        if ((topLeft.getX() + botRight.getX()) / 2 >= p.getX()
                && (topLeft.getY() + botRight.getY()) / 2 < p.getY()) {

            if (botLeftTree == null) {
                return null;
            }
            else {
                return botLeftTree.search(p);
            }
        }
        if ((topLeft.getX() + botRight.getX()) / 2 < p.getX()
                && (topLeft.getY() + botRight.getY()) / 2 >= p.getY()) {

            if (topRightTree == null) {
                return null;
            }
            else {
                return topRightTree.search(p);
            }
        }
        if ((topLeft.getX() + botRight.getX()) / 2 < p.getX()
                && (topLeft.getY() + botRight.getY()) / 2 < p.getY()) {

            if (botRightTree == null) {
                return null;
            }

        }
        return botRightTree.search(p);
    }

    /**
     * @param type
     *            place searched for
     * @return arraylist with nodes O(n^2)
     */
    public ArrayList<Node<Point>> search(String type) {
        ArrayList<Node<Point>> list = new ArrayList<Node<Point>>();
        search(list, type);
        return list;
    }

    /**
     * @param list
     *            the list need to be filled
     * @param type
     *            type searched for
     * @return the filled list
     */
    public ArrayList<Node<Point>> search(ArrayList<Node<Point>> list,
            String type) {
        if (this.node != null) {

            if (node.getPlace().contains(type)) {
                list.add(node);
                return list;
            }
        }
        if (this.botLeftTree != null) {
            this.botLeftTree.search(list, type);
        }
        if (this.botRightTree != null) {
            this.botRightTree.search(list, type);
        }
        if (this.topLeftTree != null) {
            this.topLeftTree.search(list, type);
        }
        if (this.topRightTree != null) {
            this.topRightTree.search(list, type);
        }
        return list;
    }

    /**
     * This method take a street name and return all the locations on that
     * street. It calls the find method of the BST class.
     * 
     * @param streetname
     *            name of the street
     *                O(n)
     */
    public void streetSearch(String streetname) {
        if (streetname == null) {
            System.out.println("string is null");
            return;
        }
        StreetNode a = new StreetNode(streetname);
        if (tree.find(a) != null) {
            System.out.print(tree.find(a).getPlace().toString());
        }
    }

    /**
     * This method takes a street name and a type of place (restaurant, school,
     * library, etc.) and returns all the type_of_place locations on that
     * street. It calls the find method of the BST class and filters the
     * results.
     * 
     * @param streetName
     *            name of street
     * @param type_of_place
     *            place we are looking for on the street
     * @return
     */
    public ArrayList<Node<Point>> streetSearch(String streetName,
        String type_of_place) {
        ArrayList<Node<Point>> list = new ArrayList<Node<Point>>();
        if (streetName == null) {
            return null;
        }
        	return streetSearch(streetName, type_of_place, list, 0);
    }

    /**
     * @param streetName sname
     * @param type_of_place t.o.p
     * @param list lst
     * @param count counter
     * @return the arraylist of the streetsearch
     *     O(n^2)
     */
    public ArrayList<Node<Point>> streetSearch(String streetName,
        String type_of_place, ArrayList<Node<Point>> list, int count) {
    	    StreetNode a = new StreetNode(streetName);
        if (tree.find(a) != null) {
            int treeSize = tree.find(a).getPlace().size();
            if (count < treeSize) {
                if (tree.find(a).getPlace().get(count).getPlace()
                    .contains(type_of_place)) {
                    list.add(this.tree.find(a).getPlace().get(count));
                } 
                return streetSearch(streetName, type_of_place, list, ++count);
            }
        }
		return list;
    }

    /**
     * This method takes an origin point, a street name and a type of place
     * (restaurant, school, library, etc.) and returns all the type_of_place
     * locations on that street. It calls the find method of the BST class and
     * filters the results. The results are returned in order of distance from
     * the origin ascending. Update the distance field of the nodes and put all
     * the nodes in a MinHeap. Call removeMin until the heap is empty.
     * 
     * @param originX
     *            the x coordinate of the user location
     * @param originY
     *            the y coordinate of the user location
     * @param streetName
     *            name of the street
     * @param type_of_place
     *            type of place we are looking for on the street
     * @return          O(n^2)
     */
    public ArrayList<Node<Point>> streetSearch(int originX, int originY,
            String streetName, String type_of_place) {

        Point p = new Point(originX, originY);
        if (!inTheBound(p)) {
            return null;
        }

        // Create list filled with locations of typeOfPlace, no updated
        // distances
        ArrayList<Node<Point>> firstList = streetSearch(streetName,
                type_of_place);
        if (firstList == null) {
            return null;
        }

        // update the distance of the nodes
        firstList.trimToSize();
        for (int i = 0; i < firstList.size(); i++) {
            firstList.get(i).setDistance(
                    Math.sqrt(Math.pow((originX - firstList.get(i).getPoint().getX()), 2)
                            + Math.pow((originY - firstList.get(i).getPoint().getY()), 2)));
        }

        // Step 3: use MinHeap to organize results into a new array that

        // create an identical array from the arrayList so we can use it in the
        // MinHeap constructor
        
        //int index = firstList.size();
        
        @SuppressWarnings("unchecked")
		Node<Point> [] array = new Node[firstList.size()];
            array = firstList.toArray(array);
       //for(int i =0; i<index;i++) {
            //array[i] = firstList.get(i);
        //}
        MinHeap minHeap = new MinHeap(array, array.length, array.length);

        // create new arrayList that will hold the Nodes that are being pulled
        // out of the MinHeap
        ArrayList<Node<Point>> secondList = new ArrayList<Node<Point>>();
        while(minHeap.heapsize() > 0) {
            secondList.add((Node)minHeap.removemin());

        }
        
        //ArrayList<Node<Point>> thirdList = new ArrayList();
        
        //thirdList.addAll((Collection<? extends Node<Point>>) secondList);
        return secondList;
    }
    
    /**
     * @param x x val
     * @param y y val
     * @param description the description
     * @param streets the streets
     *  O(n * ((log(n))^3))
     */
    public void insert(int x, int y, String description, String... streets) {
        Point a = new Point(x, y);
        if (!inTheBound(a)) {
            System.out.println("out of bound");
            return;
        }
        ArrayList<String> list = new ArrayList<String>();
        list.add(description);
        Node<Point> newNode = new Node<Point>(a, list);
        if (this.search(x, y) == null) {

            for (int i = 0; i < streets.length; i++) {
            
                ArrayList<String> listt = new ArrayList<String>();
                listt.add(streets[i]);
                newNode.setStreets(listt);
            
            
            
                StreetNode sNode = new StreetNode(streets[i]);
            
                if (tree.find(sNode) == null) {
                    sNode.addPoint(newNode);
                    tree.insert(sNode);
                
                }
                else {
                    tree.find(sNode).getPlace().add(newNode);
                }
            }
        }
    }
}