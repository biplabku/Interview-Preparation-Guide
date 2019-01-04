public class LinkList {

    public LinkNode head;
    public LinkList() {
        head = null;
    }

    public void add(int val) {
        LinkNode cur = new LinkNode(val);
        if(head == null) {
            head = cur;
        }
        else{
            LinkNode count = head;
            while(count.next != null) {
                count = count.next;
            }
            count.next = cur;
        }
    }

    public LinkNode getHead() {
        return head;
    }

    public void display() {
        LinkNode cur = head;
        while(cur != null) {
            System.out.print(cur.data + " ") ;
            cur = cur.next;
        }
    }


    public LinkNode add2Numbers(LinkNode l1, LinkNode l2) {
        LinkNode result = null;
        int sum =0;
        int carry = 0;
        LinkNode prev = null;
        LinkNode nxt = null;
        while(l1 != null && l2 != null) {
            sum = l1.data + l2.data + carry;
            if(sum >= 10) {
                sum = sum % 2;
                carry = sum / 2;
            }
            LinkNode temp = new LinkNode(sum);
            result = temp;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // setting the head of the linklist is needed to resolve this issue
        if(carry != 0) {
            result.next = new LinkNode(carry);
        }

        return head.next;
    }

    public void reverseLinkList(LinkList l1) {
        LinkNode cur = l1.head;
        LinkNode prev = null;
        LinkNode nxt ;
        while(cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        l1.head = prev;
        l1.display();
    }

    public static  void main(String[] args) {
        LinkList list = new LinkList();
        list.add(2);
        list.add(4);
        list.add(3);
        LinkList list2 = new LinkList();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        // System.out.println(ls.add2Numbers(a1, a2));
        list.reverseLinkList(list);
    }
}

