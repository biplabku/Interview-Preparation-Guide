public class hasCycle {


    public boolean hasCycle(LinkNode head) {
        if(head == null) {
            return false;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
