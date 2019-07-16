import java.util.*;

public class cacheSystem {

    HashMap<Integer, Node> hmap;
    Node front = new Node();
    Node tail = new Node();
    int capacity;
    int cursize = 0;

    public cacheSystem(int capacity) {
        hmap = new HashMap<>();
        this.capacity = capacity;
        front.prev = null;
        front.next = tail;
        tail.prev = front;
        tail.next = null;
    }

    public void insert(int key, int value) {
        if(hmap.containsKey(key)) {
            Node tmpNode = hmap.get(key);
            tmpNode.value = value;
            removeNode(tmpNode);
            addFirst(tmpNode);
        }else { // if it does not contains key
            Node node = new Node(key, value);
            addFirst(node);
            hmap.put(key, node);
            if(hmap.size() > capacity) {
                int k = removeLast();
                hmap.remove(k);
            }
        }
    }

    public int removeLast(){
        return 1;
    }

    public void removeNode(Node tmpNode) {
        tmpNode.prev.next = tmpNode.next;
        tmpNode.next.prev = tmpNode.prev;
    }

    public void addFirst(Node tmpNode) {

    }


    class Node {
        public Node prev;
        public Node next;
        int key;
        int value;

        public Node() {

        }

        public Node(int k, int v){
            key = k;
            value = v;
        }
    }

    public String removeKDigits(String str, int k) {
        if(str.length() == k) {
            return "0";
        }
        int index = 0;
        StringBuilder sb = new StringBuilder(str);
        while(index < k) {
            int i = 0;
            while(i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
            index++;
        }

        while(sb.length() > 1 && sb.charAt(0) == '0' ) {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    public LinkedList<LinkedList<Character>> sortLinkList(LinkedList<LinkedList<Character>> list) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                LinkedList<Character> list1 = list.get(i);
                LinkedList<Character> list2 = list.get(j);
                changeOrder(list, list1, list2, i, j);
            }
        }
        return list;
    }



    public int LadderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord.isEmpty() || endWord == null || endWord.isEmpty()) return 0;

        int len = 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> hset = new HashSet<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String curr = queue.poll();

            }
        }
        return len;
    }


    public boolean isAdjacent(String str1, String str2) {
        int count = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }

    public void changeOrder(LinkedList<LinkedList<Character>> list, LinkedList<Character> list1, LinkedList<Character> list2, int i, int j) {
        int len1 = 0;
        int len2 = 0;
        while(len1 < list1.size() && len2 < list2.size()) {
            char ch1 = list1.get(len1);
            char ch2 = list2.get(len2);
            if(ch1 > ch2) {
                list.set(i, list2);
                list.set(j, list1);
                break;
            }else if(ch1 == ch2) {
                len1++;
                len2++;
            }else if(ch1 < ch2) {
                break;
            }
        }
    }





















































    public static void main(String[] args) {
        cacheSystem cs = new cacheSystem(2);
        String str = "1432219";
        LinkedList<Character> list1 = new LinkedList<>();
        list1.add('a');
        list1.add('b');
        list1.add('c');
        LinkedList<Character> list2 = new LinkedList<>();
        list2.add('a');
        list2.add('d');
        LinkedList<Character> list3 = new LinkedList<>();
        list3.add('c');
        list3.add('o');
        list3.add('m');

        LinkedList<LinkedList<Character>> list= new LinkedList<>();
        list.add(list3);
        list.add(list1);
        list.add(list2);

        Random rand = new Random();
        System.out.println(cs.sortLinkList(list));
    }

}
