import java.util.LinkedList;

public class reverseLinkList {


    public static void reverseLinkList(LinkList list) {
        LinkNode cur = list.head;
        LinkNode nxt;
        LinkNode prev = null;
        while(cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        list.head = prev;
        System.out.println(" ");
        list.display();
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add(8);
        list.add(2);
        list.add(5);
        list.add(4);
        list.display();
        reverseLinkList(list);
    }
}
