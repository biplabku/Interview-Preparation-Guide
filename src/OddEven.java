import java.util.HashMap;
import java.util.HashSet;

public class OddEven {

    public LinkNode head;

    public OddEven() {
        head = null;
    }

    // you have a linked list and want to find the kth to last node.
    public int kthLastNode(int k) {
        LinkNode leftNode = head;
        LinkNode rightNode =  head;
        for(int i = 0; i < k -1; i++) {
            rightNode = rightNode.next;
        }
        while(rightNode.next != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        return leftNode.data;
    }

    public int findDuplicatesFast(int[] intArray) {

        final int n = intArray.length - 1;

        // STEP 1: GET INSIDE A CYCLE
        // start at position n+1 and walk n steps to
        // find a position guaranteed to be in a cycle
        int positionInCycle = n + 1;
        for (int i = 0; i < n; i++) {

            // we subtract 1 from the current position to step ahead:
            // the 2nd *position* in an array is *index* 1
            positionInCycle = intArray[positionInCycle - 1];
        }

        // STEP 2: FIND THE LENGTH OF THE CYCLE
        // find the length of the cycle by remembering a position in the cycle
        // and counting the steps it takes to get back to that position
        int rememberedPositionInCycle = positionInCycle;
        int currentPositionInCycle = intArray[positionInCycle - 1];  // 1 step ahead
        int cycleStepCount = 1;

        while (currentPositionInCycle != rememberedPositionInCycle) {
            currentPositionInCycle = intArray[currentPositionInCycle - 1];
            cycleStepCount += 1;
        }

        // STEP 3: FIND THE FIRST NODE OF THE CYCLE
        // start two pointers
        //   (1) at position n+1
        //   (2) ahead of position n+1 as many steps as the cycle's length
        int pointerStart = n + 1;
        int pointerAhead = n + 1;
        for (int i = 0; i < cycleStepCount; i++) {
            pointerAhead = intArray[pointerAhead - 1];
        }

        // advance until the pointers are in the same position
        // which is the first node in the cycle
        while (pointerStart != pointerAhead) {
            pointerStart = intArray[pointerStart - 1];
            pointerAhead = intArray[pointerAhead - 1];
        }

        // since there are multiple values pointing to the first node
        // in the cycle, its position is a duplicate in our array
        return pointerStart;
    }


    // finding a duplicate element in a given single linklist
    // time complexity - O(N), Space Complexity - O(N)
    public boolean checkDuplicate() {
        LinkNode cur = head;
        HashSet<Integer> hset = new HashSet<>();
        while(cur != null) {
            if(hset.contains(cur.data)) {
               return true;
            }else {
                hset.add(cur.data);
            }
            cur = cur.next;
        }
        return false;
    }




    public void addNode(int val) {
        try{
            LinkNode node = new LinkNode(val);
            if(head == null) {
                head = node;
            }else {
                LinkNode cur = head;
                LinkNode prev = null;
                while(cur != null) {
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = node;
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage().toString() + " " + ex.getStackTrace());
        }

    }

    // how to handle the odd and even nodes after constructing the values one after the one.
    // Initialise 2 list and then form the list and combine them later
    public void getOddEven() {
        LinkNode oddHead = head;
        LinkNode evenHead = head.next;
        LinkNode odd = oddHead;
        LinkNode even  = evenHead;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        display();
    }

    public void display() {
        LinkNode cur = head;
        while(cur != null) {
            System.out.println(cur.data + " ");
            cur  = cur.next;
        }
    }

    public void deleteNodeList( LinkNode node) {
        LinkNode nxt = null;
        LinkNode cur = head;
        while(cur != null) {
            if(cur.data == node.data) {
                break;
            }
            cur = cur.next;
        }
        nxt = cur.next;
        cur.data = nxt.data;
        cur.next = nxt.next;
    }


    // deleting the given node when given access to that particular node
    // 12 -- 1 -- 3 -- 7 -- 15 -- 4 -- 9 -- 0
    // deleting node 7 from the linklist
    // edge cases - 1. when head is the intended element
    // 2. when the intended element isthe last one
    // 3. when there is just one element
    public void deleteKNode(LinkNode node) {
        // if head is given and the node to be deleted
        LinkNode cur = head;
        LinkNode prev = head;
        // when the list has only one element
        if(head.data == node.data && head.next == null) {
            head = null;
        }
        // more than one element
        while(cur.next != null ) {
            if(cur.data == node.data) {
                prev.next = cur.next;
                cur = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }
        if(cur.data == node.data) {
            prev.next = null;
        }
    }

    // Reversing the linklist
    // O(N) time complexity
    public void reverseLinkList() {
        LinkNode prev = null;
        LinkNode nxt = null;
        LinkNode cur = head;
        while(cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        head = prev;
    }

    // meeting times

    public static void main(String[] args) {
        OddEven ds = new OddEven();
        ds.addNode(12);
        ds.addNode(1);
        ds.addNode(4);
        ds.addNode(5);
        ds.addNode(8);
        ds.addNode(0);
        ds.addNode(1);
        System.out.println(ds.checkDuplicate());
        // ds.display();
        // ds.getOddEven();
        // ds.reverseLinkList();
        // System.out.println("Reverse list is --> ");
        // ds.display();
        // LinkNode node = new LinkNode(12);
        // ds.deleteKNode(node);
        // ds.deleteNodeList(node);
        // ds.display();
        // System.out.println(ds.kthLastNode(2));
        int[] array = new int[]{3, 1, 2, 2};
        System.out.println(ds.findDuplicatesFast(array));
    }

}
