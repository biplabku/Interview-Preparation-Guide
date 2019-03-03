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
        while(cur != null) {
            if(val != k) {
                cur = cur.next;
                val++;
            }else if(val == k){
                val = 1;
                reverseList(prev, k).next = cur.next;
                prev = cur.next;
            }
        }
        return head;
    }

    public LinkNode reverseList(LinkNode head, int k) {
        LinkNode prev = null;
        LinkNode nxt = null;
        LinkNode cur = head;
        int val = k;
        while(cur != null && k != 0) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
            k--;
        }
        while(val != 0 && prev.next != null) {
            prev = prev.next;
            val--;
        }
        return prev;
    }












    public static void main(String[] args) {
        burstBalloons bs = new burstBalloons();
        String str = "dog dog cat dog";
        String pattern = "aaba";
        int[] array = {2,2,1};


        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(bs.getGroupReverse(node1, 2));
    }
}
