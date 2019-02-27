import java.util.*;

public class intersectList {

    public int getRussianDollImplementation(List<List<Integer>> list) {
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            List<Integer> temp1 = list.get(i);
            Stack<List<Integer>> theStack = new Stack<>();
            theStack.push(temp1);
            for(int j = 0; j < list.size(); j++) {
                if(i != j) {
                    List<Integer> temp2 = list.get(j);
                    if(temp1.get(0) < temp2.get(0) && temp1.get(1) < temp2.get(1)) {
                        if(!theStack.isEmpty()) {
                            Stack<List<Integer>> tmpStack = new Stack<>();
                            List<Integer> cur = theStack.peek();
                            while(cur.get(0) > temp2.get(0) && cur.get(1) > temp2.get(1) && !theStack.isEmpty()) {
                                tmpStack.push(theStack.pop());
                            }
                            if(theStack.isEmpty() || theStack.peek().get(0) < temp2.get(0) && theStack.peek().get(1) < temp2.get(1) ) {
                                theStack.push(temp2);
                            }
                            while(!tmpStack.isEmpty()) {
                                theStack.push(tmpStack.pop());
                            }
                        }else {
                            theStack.push(temp2);
                        }
                    }
                    max = Math.max(max, theStack.size());
                }
            }
        }
        return max;
    }

    public int getRussianDollImplemen(int[][] list) {
        int max = 0;
        for(int i = 0; i < list.length; i++) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(list[i][0]);
            temp1.add(list[i][1]);
            Stack<List<Integer>> theStack = new Stack<>();
            theStack.push(temp1);
            for(int j = 0; j < list.length; j++) {
                if(i != j) {
                    List<Integer> temp2 = new ArrayList<>();
                    temp2.add(list[j][0]);
                    temp2.add(list[j][1]);
                    if(temp1.get(0) < temp2.get(0) && temp1.get(1) < temp2.get(1)) {
                        if(!theStack.isEmpty()) {
                            Stack<List<Integer>> tmpStack = new Stack<>();
                            List<Integer> cur = theStack.peek();
                            while(cur.get(0) > temp2.get(0) && cur.get(1) > temp2.get(1) && !theStack.isEmpty()) {
                                tmpStack.push(theStack.pop());
                            }
                            if(theStack.isEmpty() || theStack.peek().get(0) < temp2.get(0) && theStack.peek().get(1) < temp2.get(1) ) {
                                theStack.push(temp2);
                            }
                            while(!tmpStack.isEmpty()) {
                                theStack.push(tmpStack.pop());
                            }
                        }else {
                            theStack.push(temp2);
                        }
                    }
                    max = Math.max(max, theStack.size());
                }
            }
        }
        return max;
    }

    public int bruteRussianDoll(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        int max = 1;
        int[] arr = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            arr[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    arr[i] = Math.max(arr[i], arr[j]+1);
                }
            }
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public  LinkNode findIntersectNode(LinkNode head1, LinkNode head2) {
        int size1 = 0;
        int size2 = 0;
        LinkNode cur1 = head1;
        LinkNode cur2 = head2;
        while(cur1 != null) {
            size1++;
            cur1 = cur1.next;
        }
        while(cur2 != null) {
            size2++;
            cur2 = cur2.next;
        }
        int val = Math.abs(size1 - size2);
        LinkNode temp1 = head1;
        LinkNode temp2 = head2;
        if(size1 > size2 ){
            while(val != 0) {
                temp1 = temp1.next;
                val--;
            }
        }else if(size1 < size2) {
            while(val != 0) {
                temp2 = temp2.next;
                val--;
            }
        }
        while(temp1 != null & temp2 != null && temp1.data != temp2.data) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;

    }

    public LinkNode removeLinkElements(LinkNode head, int val) {
        LinkNode cur = head;
        LinkNode nxt = cur.next;

        while(cur != null) {

        }
        return null;
    }



    public void getTest(int number) {
        System.out.println(number / 10);
        String str = "1234";
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            sum += Integer.valueOf(str.charAt(i));
        }
        System.out.println(sum);
    }

    static String GetCheckDigitAndCheckCode(String input) {
        /*
         * Write your code here.
         */
        int sum = 0;
        for(int i = 0; i < input.length(); i++) {
            if(i%2 == 0 || i == 0) {

                sum += 3 * Character.getNumericValue(input.charAt(i));
            }else {
                sum += Character.getNumericValue(input.charAt(i));
            }
        }
        int subDigit = ((sum/10) + 1 ) * 10;
        int checkDigit = subDigit - sum;

        input = input + checkDigit;


        int digit1 = get9Digits(input.substring(0, 8));
        int digit2 = get9Digits(input.substring(9));

        // NOTE - Not able to understand what means by index of 2
        // digit numbers so here am just adding instead of multiplying the 2 9 digits.
        int result = digit1 + digit2 + 207;
        int remainder = result % 103;

        StringBuilder sb = new StringBuilder();
        sb.append(checkDigit);
        sb.append(',');
        sb.append(remainder);
        return sb.toString();
    }

    public static  int get9Digits(String str) {
        int val = 0;
        for(int i = 0; i < str.length(); i++) {
            val = val * 10 + Character.getNumericValue(str.charAt(i));
        }
        return  val;
    }


    public String runLengthCoding(String str) {
        str = str.trim();
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, 1);
            }else {
                hmap.put(ch, hmap.get(ch) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator iter = hmap.entrySet().iterator();
        for(int i =0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(hmap.containsKey(ch)) {
                sb.append(hmap.get(ch));
                sb.append(ch);
                hmap.remove(ch);
            }
        }
        return sb.toString();
    }

    public String runLengthCorrect(String str) {
        Stack<Character> theStack = new Stack<>();
        theStack.push(str.charAt(0));
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(theStack.peek() == ch) {
                theStack.push(ch);
            }else {
                sb.append(theStack.size());
                sb.append(theStack.peek());
                theStack.clear();
                theStack.push(ch);
            }
        }
        sb.append(theStack.size());
        sb.append(theStack.peek());
        theStack.clear();
        return sb.toString();
    }


    public int makingAnagrams(String str1, String str2) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i =0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, 1);
            }else {
                hmap.put(ch, hmap.get(ch) + 1);
            }
        }
        int count = 0;
        for(int  i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if(hmap.containsKey(ch)) {
                int val = hmap.get(ch);
                if(val == 0) {

                }else {
                    val = val - 1;
                    hmap.put(ch, val);
                    count++;
                }
            }
        }
        return (str1.length() - count) + (str2.length() - count);
    }

    public void MakeTheNumbersMatch(int a, int b, int x, int y) {
        while(a!=x && b!=y)
        {
            if(a> x)
            {
                a--;
            }
            else
            {
                a++;
            }
            if(b>y)
            {
                b--;
            }
            else
            {
                b++;
            }
        }
    }

    public String[] findRelativeRanks(int[] nums) {
        TreeMap<Integer, Integer> hmap = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], i);
            }
        }
        String[] words = new String[nums.length];
        Iterator iter = hmap.entrySet().iterator();

        HashMap<Integer, String> tmap = new HashMap<>();
        int count = nums.length;
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            int key = (int)pair.getKey();
            int value = (int)pair.getValue();
            value = count;
            count--;
            hmap.put(key, value);
        }
        for(int i = 0; i < nums.length; i++) {
            if(hmap.get(nums[i]) == 1) {
                words[i] = "Gold Medal";
            }else if(hmap.get(nums[i]) == 2) {
                words[i] = "Silver Medal";
            }else if(hmap.get(nums[i]) == 3) {
                words[i] = "Bronze Medal";
            }else {
                words[i] = hmap.get(nums[i]).toString();
            }
        }
        return words;
    }

    // [2, 6, 4, 8, 10, 9, 15]
    // output - 5
    public int findUnsortedSubarray(int[] nums) {
        int leftIndex = Integer.MAX_VALUE;
        int rightIndex = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                leftIndex = Math.min(leftIndex, nums[i - 1]);
            }
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] > nums[i + 1]) {
                rightIndex = Math.max(rightIndex, nums[i]);
            }
        }
        int left;
        int right;
        for(left = 0; left < nums.length; left++) {
            if(leftIndex < nums[left]) {
                break;
            }
        }
        for(right = nums.length - 1; right >= 0; right--) {
            if(rightIndex > nums[right]) {
                break;
            }
        }
        return (right - 1) < 0 ? 0: (right - 1 + 1);
    }


    public int minimumDeleteSum(String str1, String str2) {
        
    }


    public static void main(String[] args) {
        int[][] array = {{2,100}, {3,200}, {4,300}, {5,500}, {5,400}, {5, 250}, {6,370}, {6,360}, {7,380}};

        intersectList ls = new intersectList();

        LinkNode node1 = new LinkNode(3);
        LinkNode node2 = new LinkNode(5);
        LinkNode node3 = new LinkNode(1);
        LinkNode node4 = new LinkNode(8);
        LinkNode node5 = new LinkNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LinkNode nod1 = new LinkNode(99);
        LinkNode nod2 = new LinkNode(1);
        LinkNode nod3 = new LinkNode(8);
        LinkNode nod4 = new LinkNode(10);
        nod1.next = nod2;
        nod2.next = nod3;
        nod3.next = nod4;

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>();
        t1.add(5);
        t1.add(4);
        List<Integer> t2 = new ArrayList<>();
        t2.add(6);
        t2.add(4);
        List<Integer> t3 = new ArrayList<>();
        t3.add(6);
        t3.add(7);
        List<Integer> t4 = new ArrayList<>();
        t4.add(2);
        t4.add(3);
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        int[] nums = {2,1};
        System.out.println(ls.findUnsortedSubarray(nums));
    }
}
