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
}

