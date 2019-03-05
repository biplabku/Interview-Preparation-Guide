import java.util.HashMap;

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
        while(nxtHead != null) {
            nxtHead.next = cur;
            nxtHead = nxtHead.next;
            cur = cur.next;
        }
        return nxtHead;
    }






    public static void main(String[] args) {
        burstBalloons bs = new burstBalloons();
        String str = "dog dog cat dog";
        String pattern = "aaba";
        int[] array = {3,3,7,7,10,11,11};


        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(bs.swapLinkNodes(node1));
    }
}
