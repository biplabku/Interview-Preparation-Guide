import java.util.*;

public class burstBalloons {


    public boolean wordPattern(String str, String pattern) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, i);
                sb.append(i);
            }else {
                sb.append(hmap.get(ch));
            }
        }
        str.trim();
        hmap.clear();
        HashMap<String, Integer> hmap1 = new HashMap<>();
        StringBuilder sb1= new StringBuilder();

        String[] ar = str.split("\\s+");
        for(int i = 0; i < ar.length; i++) {
            String st = ar[i];
            if(!hmap1.containsKey(st)) {
                hmap1.put(st, i);
                sb1.append(i);
            }else {
                sb1.append(hmap1.get(st));
            }
        }
        return sb.toString().equals(sb1.toString());
    }

    public boolean wordPatternFast(String str, String pattern) {
        str.trim();
        String[] ar = str.split("\\s+");
        if(ar.length != pattern.length()) return false;
        HashMap<Character, String> hmap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if(!hmap.containsKey(ch) && !hmap.containsValue(ar[counter])) {
                sb.append(ch);
                hmap.put(ch, ar[counter]);
                counter++;
            }else if(!hmap.containsValue(ar[counter])){
                return false;
            }else if(hmap.containsValue(ar[counter]) && hmap.containsKey(ch)) {
                if(!hmap.get(ch).toString().equals(ar[counter])) {
                    return false;
                }
                sb.append(ch);
                counter++;
            }
        }
        return pattern.equals(sb.toString());
    }

    public boolean validMountain(int[] array) {
        if(array.length <= 2) {
            return false;
        }
        int leftIndex = 1;
        int rightIndex = array.length - 2;
        int left = array[0];
        int right = array[array.length - 1];
        for(int i = 0; i < array.length - 1; i++) {
            if(left <= array[i + 1]) {
                left = array[i + 1];
                leftIndex = i  + 1;
            }else {
                break;
            }
        }
        for(int i = array.length - 1; i > 0; i--) {
            if(right <= array[i - 1]) {
                right = array[i - 1];
                rightIndex = i - 1;
            }else {
                break;
            }
        }
        if(rightIndex < leftIndex) return false;

        return true;
    }



    public LinkNode getGroupReverse(LinkNode head, int k) {
        LinkNode cur = head;
        int val = 0;
        LinkNode prev = head;
        LinkNode p = head;
        while(cur != null) {
            if(val != k) {
                cur = cur.next;
                p = cur;
                val++;
            }else if(val == k){
                val = 0;
                prev = reverseList(prev, k);
                while(prev.next != null) {
                    prev = prev.next;
                }
                prev.next = cur;
                cur = p;
            }
        }
        return head;
    }

    public LinkNode reverseList(LinkNode head, int k) {
        LinkNode prev = null;
        LinkNode nxt;
        LinkNode cur = head;
        while(cur != null && k != 0) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
            k--;
        }
        return prev;
    }
    //
    // 1 1 2 2 3 3 4
    //       2
    // 1 1 2 3
    //     2

    public int singleElementSortedArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while(low < high) {
            int mid = (low + high )/2;
            if(mid % 2 == 0) {
                if(array[mid] == array[mid + 1]) {
                    low = mid + 2;
                }else {
                    high = mid;
                }
            }else if(mid % 2 == 1){
                if(array[mid] == array[mid - 1]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return  array[low];
    }


    public void search(int[] arr, int low, int high) {
        if(low > high)
            return;
        if(low == high)
        {
            System.out.println("The required element is "+arr[low]);
            return;
        }
        int mid = (low + high)/2;
        if(mid % 2 == 0)
        {
            if(arr[mid] == arr[mid+1])
                search(arr, mid+2, high);
            else
                search(arr, low, mid);
        }
        // If mid is odd
        else if(mid % 2 == 1)
        {
            if(arr[mid] == arr[mid-1])
                search(arr, mid+1, high);
            else
                search(arr, low, mid-1);
        }
    }


    // 1 -- 2 -- 3 -- 4
    // 2 -- 1 -- 4 -- 3
    public LinkNode swapLinkNodes(LinkNode head) {
        LinkNode cur = head;
        LinkNode nxtHead = head.next;
        LinkNode fakeNode = nxtHead;
        LinkNode nxt = head.next;
        while(cur.next != null && cur != null) {
            nxtHead.next = nxt;
            nxtHead = nxtHead.next;
            nxtHead.next = nxt.next;
            nxt = nxt.next.next;
        }
        return fakeNode;
    }

    // [{2,15}, {36,45}, {9,29}, {16,23}, {4,9}]
    // {2,15}, {4,9}, {9,29}, {16,23}, {36,45}
    // 2,15
    // 4, 9
    public int minConferenceRoom(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.startTime - o2.startTime;
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0].endTime);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i].startTime >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i].endTime);
        }
        return queue.size();

    }

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, IntervalComparator);
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer((intervals[0].endTime));
        for(int i=1; i<intervals.length; i++){
            if(intervals[i].startTime >= endTimes.peek()) endTimes.poll();
            endTimes.offer(intervals[i].endTime);
        }
        return endTimes.size();
    }

    private static Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval l1, Interval l2){
            return l1.startTime - l2.startTime;
        }
    };

    // 1->2->6->3->4->5->6
    public LinkNode removeDuplicateElements(LinkNode head, int val) {
        LinkNode cur = head.next;
        LinkNode prev = head;
        while(cur != null) {
            if(cur.data == val) {
                prev.next = cur.next;
            }else {
                prev = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }

    // 1 -- 2 -- 3 -- 4 -- 5
    // cur = 2
    // pre = 1
    public LinkNode swapNodes(LinkNode head) {
        LinkNode prev = head;
        LinkNode cur = head.next;
        head = prev;
        while(true) {
            LinkNode nxt = cur.next;
            cur.next = prev;
            if (nxt == null || nxt.next == null) {
                prev.next = nxt;
                break;
            }
            prev.next = nxt.next;
            prev = nxt;
            cur = prev.next;
        }
        return head;
    }

    public LinkNode reverseKGroups(LinkNode head, int k) {
        return head;
    }

    public String temp(String str) {
        int inde = str.indexOf('[');
        int inde2 = str.indexOf(']');
        str = str.substring(inde, inde2);
        return str;
    }

    public List<Integer> largestValue(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        result.add(root.data);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size != 0) {
                TreeNode temp = queue.poll();
                if(temp.leftChild != null) {
                    left = Math.max(left, temp.leftChild.data);
                    queue.offer(temp.leftChild);
                }
                if(temp.rightChild != null) {
                    right = Math.max(right, temp.rightChild.data);
                    queue.offer(temp.rightChild);
                }
                size--;
            }
            result.add(Math.max(left, right));
        }
        return result;
    }

    public void moveZeros(int[] array) {
        int pointer1 = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                swap(pointer1, i, array);
                pointer1 = pointer1 + 1;
            }
        }
        display(array);
    }

    public int findDuplicate(int[] array) {
        int slow = array[0];
        int fast = array[1];
        int n = array.length;
        while(array[slow] != array[fast]) {
            slow = (slow + 1) % n;
            fast = (fast + 2) % n;
            if(fast == slow) {
                fast = (fast + 1) % n;
            }
        }
        return array[slow];
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public boolean stringExists(char[][] grid, String word) {

        Queue<Character> queue = new LinkedList<>();
        queue.offer(word.charAt(0));
        boolean[][] visted = new boolean[grid.length][grid[0].length];


        return false;
    }

    public List<String> flightProblem(List<List<String>> list, String str) {
        PriorityQueue<String> result1 = new PriorityQueue<>();
        List<String> result = new ArrayList<>();
        result.add(str);
        HashSet<Integer> hset = new HashSet<>();
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size(); j++) {
                String key = list.get(j).get(0);
                if(str.equalsIgnoreCase(key)) {
                    if(hset.contains(j)) {
                        continue;
                    }
                    result.add(list.get(j).get(1));
                    hset.add(j);
                    str = list.get(j).get(1);
                }
            }
        }
        if(result.size() == 2) {
            return null;
        }
        return result;
    }


    public boolean checkPalindromeWithDelete(String str) {
        int left = 0;
        int right = str.length() - 1;
        int count = 0;
        while(left < right) {
            if(str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            }else {
                count++;
                if(count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    //  2, 4, 6, 2, 5
    //  5, 1, 1, 5

    public int largestNonAdjacent(int[] array) {
        int max1 = array[0];
        int max2 = 0;
        int max3 ;
        int i;
        for(i = 1; i < array.length; i++ ) {
            max3 = max1 > max2 ? max1:max2;
            max1 = max2 + array[i];
            max2 = max3;
        }
        return max1 > max2 ? max1 : max2;
    }


    public static void main(String[] args) {
        burstBalloons bs = new burstBalloons();
        String pattern = "aaba";
        int[] array = {5, 1, 1, 5};


        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Interval[] list = new Interval[3];
        list[0] = new Interval(0,30);
        list[1] = new Interval(5,10);
        list[2] = new Interval(15,20);
        //list[3] = new Interval(16,23);
        // list[4] = new Interval(4,9);

        List<List<String>> temp = new ArrayList<>();
        List<String> t = new ArrayList<>();
        t.add("A");
        t.add("B");
        List<String> t1 = new ArrayList<>();
        t1.add("A");
        t1.add("C");
        List<String> t2 = new ArrayList<>();
        t2.add("B");
        t2.add("C");
        List<String> t3 = new ArrayList<>();
        t3.add("C");
        t3.add("A");
        temp.add(t);
        temp.add(t1);
        temp.add(t2);
        temp.add(t3);

        String str = "geeks";
        char[][] grid = {{'a','x','m','y'}, {'b', 'g', 'd', 'f'},
                {'x','e', 'e', 't'}, {'r','a','k', 's'}};
        System.out.println(bs.largestNonAdjacent(array));
    }
}
