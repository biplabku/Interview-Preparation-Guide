import java.util.HashMap;

public class LRUCacheImp {

    public static HashMap<Integer, Node> hmap = new HashMap<>();
    public static int capacity;
    public static int count;
    public static Node head;
    public static Node tail;

    public LRUCacheImp(int val) {
        capacity = val;
        count = 0;
        head.pre = null;
        head.next = null;
        tail = head;

    }

    public static void put(int number, int value) {
        Node n = hmap.get(number);
        if(n == null) {
            n = new Node(number, value);
            hmap.put(number, n);
            add(n);
            ++count;
        }else {
            n.value = value;
            update(n);
        }
        if(count > capacity) {
            Node del  = tail.pre;
            remove(del);
            hmap.remove(del);
            --count;
        }
    }

    public static void update(Node n) {
        remove(n);
        add(n);
    }

    public static void remove(Node n) {
        Node before = n.pre;
        Node after = n.next;
        before.next = after;
        after.pre = before;
    }

    public static void add(Node node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    /*
    public int getKey(int key) {
        Node nnode = hmap.get(new Integer(key));
        if(nnode == null) {
            return -1;
        }
        return 1;
    }
    */

    public static void main(String[] args) {
        LRUCacheImp lp = new LRUCacheImp(3);

    }

}
