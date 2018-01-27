import java.util.Stack;

public class linkListPalindrome {

    public static boolean linkListPalindrome(LinkList list) {
        Stack<Integer> stack = new Stack<>();
        LinkNode head = list.head;
        while(head != null) {
            stack.push(head.data);
            head = head.next;
        }
        head = list.head;
        while(!stack.isEmpty()) {
            if(stack.pop() != head.data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add(-1);
        list.add(-1);

        System.out.println(linkListPalindrome(list));
    }

}
