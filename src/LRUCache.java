import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LRUCache {

    public int capacity ;
    public Stack<Integer> theStack = new Stack<>();
    public HashMap<Integer, Integer> hmap = new HashMap<>();

    public LRUCache(int val) {
        capacity = val;
    }

    public int getElement(int key) {
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }else {
            return -1;
        }
    }

    public int insertElement(int key, int val) {
        if(!hmap.containsKey(key) && hmap.size() != capacity) {
            hmap.put(key, val);
            theStack.push(key);
        }else if(hmap.size() == capacity) {
            hmap.remove(theStack.pop());
            hmap.put(key, val);
            theStack.push(key);
        }
        return theStack.peek();
    }

    public static void main(String[] args) {
        LRUCache ls = new LRUCache(3);
        ls.insertElement(1,12);
        ls.insertElement(2,22);
        ls.insertElement(3,32);
        System.out.println(ls.getElement(1));
        ls.insertElement(4, 44);
        System.out.println(ls.getElement(3));


    }
}
