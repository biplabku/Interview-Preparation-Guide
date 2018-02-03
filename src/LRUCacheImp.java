import java.util.HashMap;

public class LRUCacheImp {

    public static HashMap<Integer, Node> hmap = new HashMap<>();
    public static int capacity;
    public int number;
    public Node head;
    public Node tail;

    public LRUCacheImp(int val) {
        capacity = val;
        number = 0;
        head = new Node(-1,-1);
        head.pre = null;
        head.next = null;
        tail = head;
    }

    public static void putElements(int number, int value) {
        Node nnode = hmap.get(number);
        if(nnode == null) {
            nnode = new Node()
        }
    }

    public int getKey(int key) {
        Node nnode = hmap.get(new Integer(key));
        if(nnode == null) {
            return -1;
        }
    }

    public static void main(String[] args) {
        LRUCacheImp lp = new LRUCacheImp(3);

    }

}
