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
            currentMax = currentMax + array[i];
            if(finalMax < currentMax) {
                finalMax = currentMax;
                rightIndex = i;
            }
            if(currentMax < 0) {
                currentMax = 0;
                leftIndex = i + 1;
            }
        }
        List<Integer> list = Arrays.asList(leftIndex, rightIndex);
        return list;
    }

    public boolean searchTarget(int[][] array, int target) {
        if(array == null || array.length == 0 || array[0].length == 0 || array[0] == null) {
            return false;
        }
        int row = 0;
        int col = 0;
        boolean seen = false;
        if(array.length == 1) {
            int[] ar = new int[array[0].length];
            for(int i = 0; i <  array[0].length; i++) {
                ar[i] = array[0][i];
            }
            return binarySearch(ar, 0,array.length, target);
        }
        if(array[0].length == 1) {
            int[] ar = new int[array.length];
            for(int i = 0; i <  array.length; i++) {
                ar[i] = array[i][0];
            }
            return binarySearch(ar, 0,array.length, target);
        }
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {

            }
        }
        int[] rowArray = new int[row + 1];
        int[] colArray = new int[col + 1];

        for(int i = 0; i <=  col; i++) {
            rowArray[i] = array[row][i];
        }

        for(int i = 0; i <= row; i++) {
            colArray[i] = array[i][col];
        }
        return binarySearch(rowArray, 0, row, target) == true || binarySearch(colArray, 0, col, target) == true;
    }

    public boolean binarySearch(int[] array, int start, int end, int target) {
        if(array.length == 1) {
            return target == array[0];
        }
        while(start <= end) {
            int mid = (start + end )/2;
            if(array[mid] == target) {
                return true;
            }
            if(target > array[mid]) {
                start = mid + 1;
            }else if(target < array[mid]) {
                end = mid -1;
            }
        }
        return false;
    }


    public int[] dailyTemperatures(int[] temperature) {
        int[] result = new int[temperature.length];

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
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[][] array = {{-1},{-1}};
        System.out.println(ls.searchTarget(array, 0));


    }
}
