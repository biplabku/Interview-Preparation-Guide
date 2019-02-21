import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    


    public static void main(String[] args) {
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

        intersectList ls = new intersectList();
        System.out.println(ls.getRussianDollImplementation(list));
    }
}
