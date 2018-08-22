import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {


    public BSTNode root;

    public levelOrderTraversal(int data) {
        root.data = data;
    }

    // we will pas the root to this function
    // there are 2 methods which can help in getting this to work.
    // At first glance it seems that Breadth first search is the right way to go
    public List<List<Integer>> getLevelElements(BSTNode node) {
        List<List<Integer>> theList = new ArrayList<>();
        Queue<BSTNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            List<Integer> link = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                BSTNode current = queue.poll();
                link.add(current.data);
                if(current.leftChild != null) {
                    queue.offer(current.leftChild);
                }else if(current.rightChild != null) {
                    queue.offer(current.rightChild);
                }
            }
            theList.add(link);
        }
        return theList;
    }


    public static void main(String[] args) {

    }
}
