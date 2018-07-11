public class mergeList {

    public LinkNode mergeKList(LinkNode l1, LinkNode l2) {
        LinkNode head = new LinkNode(0);
        LinkNode cur = head;
        while(l1 != null && l2 != null) {
            if(l1.data <= l2.data) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public LinkNode mergeKListImplementation(LinkNode[] lists) {
        LinkNode node = new LinkNode(0);
        for(int i = 0; i < lists.length; i++) {
            node.next = mergeKList(node, lists[i]);
        }
        return node.next;
    }

    public void mergeKLists(LinkList l1, LinkList l2) {
        LinkNode cur1 = l1.head;
        LinkNode cur2 = l2.head;
        LinkList list = new LinkList();
        while(cur1 != null && cur2 != null) {
            if(cur1.data <= cur2.data) {
                list.add(cur1.data);
                list.add(cur2.data);
                cur1 = cur1.next;
                cur2 = cur2.next;
            }else {
                list.add(cur2.data);
                cur2 = cur2.next;
            }
        }
        list.add(cur1 != null ? cur1.data : cur2.data);
        /*
        while(cur1 != null) {
            list.add(cur1.data);
            cur1 = cur1.next;
        }
        while(cur2 != null) {
            list.add(cur2.data);
            cur2 = cur2.next;
        }
        */
        // list.display();
    }

    public void mergKlistIm(LinkList[] lists) {
        LinkList result = new LinkList();
        for(int i = 0; i < lists.length; i++) {
            mergeKLists(lists[i], result);
        }
        result.display();
    }

    public static void main(String[] args) {
        LinkList l2 = new LinkList();
        LinkList l1 = new LinkList();
        LinkList l3 = new LinkList();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        l2.add(1);
        l2.add(3);
        l2.add(4);
        l3.add(1);
        l3.add(3);
        l3.add(4);
        LinkList[] lists = new LinkList[]{l1, l2, l3};
        mergeList ms = new mergeList();
        // desired output should be
        // 1 -- 1 -- 2 -- 3 -- 4 -- 4
        ms.mergeKLists(l1,l2);
        ms.mergKlistIm(lists);
    }
}
