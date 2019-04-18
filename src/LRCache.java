import java.util.HashMap;
import java.util.List;

public class LRCache {

    class Node {
        Node next;
        Node prev;
        int key;
        int value;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> hmap = new HashMap<>();
    int capacity;
    Node head;
    Node tail;
    int count ;
    public LRCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        Node node = hmap.get(key);
        if(node == null) {
            node = new Node(key, value);
            hmap.put(key, node);
            addNode(node);
            ++count;
            if(count > capacity) {
                tail = popTail();
                hmap.remove(tail.key);
                --count;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    public int get(int key) {
        Node node = hmap.get(key);
        if(node == null) {
            return  -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    public void removeNode(Node node) {
        Node pre = node.prev;
        Node nxt = node.next;
        pre.next = nxt;
        nxt.prev = pre;
    }

    public void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;

    }
    private Node popTail(){
        Node res = tail.prev;
        this.removeNode(res);
        return res;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseKGroups(ListNode head, int k) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int counter = 0;
        while(cur != null) {
            ++counter;
            if(counter % k == 0) {
                prev = revese(prev, cur.next);
            }
        }
        return newHead;
    }

    public ListNode revese(ListNode prev, ListNode end) {
        ListNode head = prev;
        ListNode cur = head.next;
        while(cur != end) {
            ListNode temp = cur.next;
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
            k--;
        }
        if(k > 0) {
            return null;
        }
        return prev;
    }

    public static void main(String[] args) {
        LRCache ls = new LRCache(2);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(ls.reverseKGroups(l1, 2));


    }
}
