import java.util.*;

public class MapTutorials {

    // LinkedHashMap is a common implementation of Map interface
    // It is similar to HashMap in most aspects. However, the linked hashmap is
    // based on both hash table and linked list to enhance the functionality of the
    // hashmap

    public boolean isPalindromeNumber(int number) {
        if(number < 0) {
            return false;
        }
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder(str);
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    public boolean isPalindromeMethod2(int number) {
        int original = number;
        if(number < 0) {
            return false;
        }
        int result = 0;
        while(number != 0) {
            result = result * 10 +  (number % 10);
            number = number / 10;
        }
        return  result == original;
    }


    public void linkedHashMap( ) {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(5, "apple");
        hmap.put(0, "mango");
        hmap.put(-1, "tango");
        hmap.put(9, "apple");
        hmap.put(10, "mango");
        hmap.put(8, "tango");
        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            System.out.println((int)pair.getKey());
        }
        System.out.println("done");

        LinkedHashMap<Integer, String> tmap = new LinkedHashMap<>();
        tmap.put(5, "apple");
        tmap.put(0, "mango");
        tmap.put(-1, "tango");
        tmap.put(9, "apple");
        tmap.put(10, "mango");
        tmap.put(8, "tango");
        Iterator iter1 = tmap.entrySet().iterator();
        while(iter1.hasNext()) {
            Map.Entry pair = (Map.Entry) iter1.next();
            System.out.println((int)pair.getKey());
        }
    }

    public int majorityElement(List<Integer> list) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i =0; i< list.size(); i++) {
            if(!hmap.containsKey(list.get(i))) {
                hmap.put(list.get(i), 1);
            }else {
                hmap.put(list.get(i), hmap.get(list.get(i)) + 1);
            }
        }
        int max = 0;
        int res = 0;
        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            int val = (int)pair.getValue();
            if(max < val) {
                max = val;
                res = (int)pair.getKey();
            }
        }

        if(max > list.size()/2) {
            return res;
        }
        return -1;
    }

    public int majorityElementMethod2 (List<Integer> list) {
        int maj = list.get(0);
        int count = 1;
        int maj_index = 0;
        int i;
        for(i = 1; i < list.size(); i++) {
            if(maj == list.get(i)) {
                count++;
            }else {
                count--;
            }
            if(count == 0) {
                maj = list.get(i);
                maj_index = i;
                count = 1;
            }
        }
        return list.get(maj_index);
    }

    // array of Strings
    public String longCommonPrefix(String[] str) {
        if(str.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < str.length; i++) {
            min  = Math.min(min, str[i].length());
        }
        if(min  == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < min; i++) {
            for(int j = 1; j < str.length; j++) {
                char ch1 = str[j - 1].charAt(i);
                char ch2 = str[j].charAt(i);
                if(ch1 != ch2) {
                    return sb.toString();
                }
            }
            char ch = str[0].charAt(i);
            sb.append(str[0].charAt(i));
        }
        return sb.toString();
    }


    public ListNode findNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode back = head;
        int k = 0;
        while(front != null) {
            if(k >= n) {
                back = back.next;
            }
            front = front.next;
            k++;
        }
        return back;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode back = head;
        int k = 0;
        ListNode prev = head;
        ListNode next = head;
        while(front != null) {
            if(k >= n) {
                prev = back;
                back = back.next;
                next = back.next;
            }
            front = front.next;
            k++;
        }
        prev.next = next;
        return back;
    }


    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int data) {
            val = data;
            next = null;
        }
    }


    public static void main(String[] args) {
        MapTutorials ms = new MapTutorials();
        // ms.linkedHashMap();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        // System.out.println(ms.majorityElementMethod2(list));
        String[] str = new String[]{"abca", "abc"};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // System.out.println(ms.longCommonPrefix(str));
        System.out.println(ms.findNthFromEnd(head, 2).val);
    }
}
