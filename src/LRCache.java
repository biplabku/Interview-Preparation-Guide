import java.util.ArrayList;
import java.util.Arrays;
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
        ListNode newHead = null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int counter = 0;
        while(cur != null) {
            ++counter;
            if(counter % k == 0) {
                prev = revese(k, prev, cur.next);
            }
        }
        return newHead;
    }

    public ListNode revese(int k, ListNode prev, ListNode end) {
        ListNode head = prev;
        ListNode cur = head.next;
        ListNode nxt = null;
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


    public int[] prodOfSelf(int[] array) {
        int[] newArray = new int[array.length];
        newArray[0]  = array[0];
        for(int i = 1; i < array.length; i++) {
            newArray[i] = array[i - 1] * newArray[i - 1];
        }
        int num = 1;
        for(int i = array.length - 1; i >= 0; i--) {
            newArray[i] = num * newArray[i];
            num = num * array[i];
        }
        return newArray;
    }

    public List<Integer> locateSmallest(int[] array) {
        int left = 0;
        int right = 0;
        boolean isSeen = false;
        for(int i = 0; i < array.length; i++) {
            if((i + 1) < array.length && array[i] > array[i + 1] && isSeen == false) {
                left = i;
                isSeen = true;
            }
            if(isSeen == true && array[left] - array[i] < 0) {
                right = i - 1;
                break;
            }
        }
        List<Integer> list= new ArrayList<>();
        list.add(left);
        list.add(right);
        return list;

    }

    public int maxSubArraySum(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            int val = array[i];
            for(int j = i + 1; j < array.length; j++) {
                val += array[j];
                if(val > sum) {
                    sum = val;
                }
            }
        }
        return sum;
    }
    // what if you need to find the arraylist from the array instead of getting the sum
    public int maxSubArraySumImprove(int[] array) {
        int currentMax = 0;
        int maxFinal = 0;
        // computer both maximums o, one including the current max and the other not including the current max
        for(int i = 0; i < array.length; i++) {
            currentMax = Math.max(array[i], currentMax + array[i]);
            maxFinal = Math.max(currentMax, maxFinal);
        }
        return maxFinal;
    }

    // 34, -50, 42, 14, -5, 86
    public List<Integer> getMaxSubarray(int[] array) {
        int leftIndex = 0;
        int rightIndex = 0;
        int currentMax = 0;
        int finalMax = 0;
        for(int i = 0; i < array.length; i++) {
            int val = currentMax + array[i];
            if(array[i] > currentMax) {
                currentMax = val;
                leftIndex = i;
            }
            if(currentMax > finalMax) {
                finalMax = currentMax;
                rightIndex = i;
            }
        }

        List<Integer> list = Arrays.asList(leftIndex, rightIndex);
        return list;
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
        int[] arr = {34, -50, 42, 14, -5, 86};
        System.out.println(ls.getMaxSubarray(arr));


    }
}
