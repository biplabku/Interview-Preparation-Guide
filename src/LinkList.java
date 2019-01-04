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


    public void add2Numbers(LinkList l1, LinkList l2) {
        LinkList result = new LinkList();
        int sum = 0;
        int carry = 0;
        LinkNode prev = null;
        LinkNode nxt = null;
        LinkNode cur1 = l1.head;
        LinkNode cur2 = l2.head;
        while(cur1 != null || cur2 != null) {
            if(cur1 != null && cur2 == null) {
                sum = carry + cur1.data;
            }
            if(cur1 == null && cur2 != null) {
                sum = carry + cur2.data;
            }
            if(cur1 != null && cur2 != null) {
                sum = carry + cur1.data + cur2.data;
            }
            if(sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            result.add(sum);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if(carry > 0) {
            result.add(carry);
        }
        result.display();
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
        list2.add(5);
        // list.reverseLinkList(list);
        list.add2Numbers(list, list2);

    }
}

