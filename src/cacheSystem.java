import java.util.HashMap;
import java.util.Stack;

public class cacheSystem {

    HashMap<Integer, Node> hmap;
    Node front = new Node();
    Node tail = new Node();
    int capacity;
    int cursize = 0;

    public cacheSystem(int capacity) {
        hmap = new HashMap<>();
        this.capacity = capacity;
        front.prev = null;
        front.next = tail;
        tail.prev = front;
        tail.next = null;
    }

    public void insert(int key, int value) {
        if(hmap.containsKey(key)) {
            Node tmpNode = hmap.get(key);
            tmpNode.value = value;
            removeNode(tmpNode);
            addFirst(tmpNode);
        }else { // if it does not contains key
            Node node = new Node(key, value);
            addFirst(node);
            hmap.put(key, node);
            if(hmap.size() > capacity) {
                int k = removeLast();
                hmap.remove(k);
            }
        }
    }

    public int removeLast(){
        return 1;
    }

    public void removeNode(Node tmpNode) {
        tmpNode.prev.next = tmpNode.next;
        tmpNode.next.prev = tmpNode.prev;
    }

    public void addFirst(Node tmpNode) {

    }


    class Node {
        public Node prev;
        public Node next;
        int key;
        int value;

        public Node() {

        }

        public Node(int k, int v){
            key = k;
            value = v;
        }
    }

    public String removeKDigits(String str, int k) {
        if(str.length() == k) {
            return "0";
        }
        int index = 0;
        StringBuilder sb = new StringBuilder(str);
        while(index < k) {
            int i = 0;
            while(i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
            index++;
        }

        while(sb.length() > 1 && sb.charAt(0) == '0' ) {
            sb.delete(0, 1);
        }
        return sb.toString();
    }





















































    public static void main(String[] args) {
        cacheSystem cs = new cacheSystem(2);
        String str = "1432219";
        System.out.println(cs.removeKDigits(str, 3));
    }

}
