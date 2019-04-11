import java.util.*;

public class linkListPalindrome {

    public static boolean linkListPalindrome(LinkList list) {
        Stack<Integer> stack = new Stack<>();
        LinkNode head = list.head;
        while(head != null) {
            stack.push(head.data);
            head = head.next;
        }
        head = list.head;
        while(!stack.isEmpty()) {
            if(stack.pop() != head.data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // prpbblem with this solution is that it will fail when there are negative numbers
    public static boolean checkPalindrome(LinkList list) {
        LinkNode cur = list.head;
        // base solution
        StringBuilder sb = new StringBuilder();
        while(cur != null) {
            sb.append(cur.data);
            cur = cur.next;
        }
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }


    public boolean isDouble(int[] array) {
        if(array == null || array.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> numToDouble = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            if(!numToDouble.containsKey(array[i]) && array[i] < Integer.MAX_VALUE/2 && array[i] > Integer.MIN_VALUE/2) {
                numToDouble.put(array[i], 2 * array[i]);
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] < Integer.MAX_VALUE/2 && array[i] > Integer.MIN_VALUE/2 && numToDouble.containsKey(array[i] * 2)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> list, int B) {
        int max1 = list.get(0);
        int max2 = list.get(1);
        int index = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int counter = 1;
        for(int i = 0; i <= (list.size() - B + 1); i++) {
            if(counter == B) {
                counter = 0;
                result.add(Math.max(max1, max2));
                index = index + 1;
                i = index - 1;
                max1 = list.get(index);
                max2 = list.get(index + 1);
            }
            counter++;
            max1 = Math.max(list.get(i), max1);
            max2 = Math.max(list.get(i + 1), max2);
        }
        return result;
    }


    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add(-1);
        list.add(-1);

        linkListPalindrome ls= new linkListPalindrome();
        int[] array = {-1,2,3,Integer.MAX_VALUE, Integer.MIN_VALUE};

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(-1);
        arr.add(-3);
        arr.add(5);
        arr.add(3);
        arr.add(6);
        arr.add(7);

        System.out.print(ls.slidingMaximum(arr, 3));
    }

}
