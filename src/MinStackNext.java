import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MinStackNext {
        int min = Integer.MAX_VALUE;

        Stack<Integer> thestack;

        public MinStackNext(){
            thestack=new Stack<>();
        }

        // 5 - 4 -1 -2
        public void push(int x) {
            if(x <= min) {
                thestack.push(min);
                min = x;
            }
            thestack.push(x);
        }

        public void pop() {
            if(thestack.pop() == min) {
                min = thestack.pop();
            }

        }

        public int top() {
            return thestack.peek();
        }


        public int getMin() {
            return min;
        }




        public List<Integer> getPartitionLabels(String str) {
            List<Integer> list =  new ArrayList<>();
            int[] last = new int[26];
            for(int i = 0; i < str.length(); i++) {
                System.out.println(str.charAt(i) - 'a');
                last[str.charAt(i) - 'a'] = i;
            }
            int j = 0;
            int anchor = 0;
            for(int i = 0; i < str.length(); i++) {
                j = Math.max(j, last[str.charAt(i) - 'a']);
                if(i == j) {
                    list.add(i - anchor + 1);
                    anchor = i + 1;
                }
            }
            return list;
        }


        public List<Integer> getPartition(String str) {
            List<Integer> list = new ArrayList<>();
            HashMap<Character, Integer> hmap = new HashMap<>();
            for(int i =0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(!hmap.containsKey(ch)) {
                    hmap.put(ch, i);
                }else {
                    hmap.put(ch, i);
                }
            }
            int max = 0 ;
            int prev = 0;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                int val = hmap.get(ch);
                for(int j = i; j < val; j++) {
                    max = hmap.get(str.charAt(j)) + 1;
                    val = Math.max(val, max);
                }
                i = val;
                int res = i - prev;
                list.add(res);
            }
            int val1 = 0;
            List<Integer> l = new ArrayList<>();
            l.add(list.get(0));
            for(int i = 1; i < list.size(); i++) {
                val1 = list.get(i-1);

                l.add(list.get(i) - val1);
            }
            return l;
        }

        public static void main(String[] args) {
            // 5-1-2-4-3
            MinStackNext ms = new MinStackNext();
            ms.push(5);
            ms.push(1);
            ms.push(2);
            ms.push(3);
            ms.push(0);
            //ms.pop();
            // System.out.println(ms.getMin());
            String str = "abccaddbeffe";
            System.out.println(ms.getPartition(str));
        }
}
