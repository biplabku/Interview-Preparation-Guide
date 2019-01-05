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
                cur1 = cur1.next;
            }
            if(cur1 == null && cur2 != null) {
                sum = carry + cur2.data;
                cur2 = cur2.next;
            }
            if(cur1 != null && cur2 != null) {
                sum = carry + cur1.data + cur2.data;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            if(sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            result.add(sum);


        }
        if(carry > 0) {
            result.add(carry);
        }
        result.display();
    }

    public LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
        int sum = 0;
        int carry = 0;
        LinkNode res = new LinkNode(0) ;
        LinkNode head = res;
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 == null) {
                sum = carry + l1.data;
                l1 = l1.next;
            }else if(l1 == null && l2 != null) {
                sum = carry + l2.data;
                l2 = l2.next;
            }else if(l1 != null && l2 != null) {
                sum = carry + l1.data + l2.data;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(sum >= 10) {
                carry = 1;
                sum = sum%10;
            }else {
                carry = 0;
            }
            res.next = new LinkNode(sum);
            res = res.next;
        }
        if(carry > 0) {
            res.next = new LinkNode(carry);
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
        // list.reverseLinkList(list);
        list.add2Numbers(list, list2);

    }
}

