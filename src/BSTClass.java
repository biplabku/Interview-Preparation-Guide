import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTClass {

    public static BSTNode root;

    public BSTClass() {
        root = null;
    }

    public void insertNode(int value) {
        if(root == null) {
            root.data = value;
            return;
        }
        BSTNode node = new BSTNode(value);
        BSTNode current = new BSTNode(root.data);
        if(current != null) {


        }
    }

    public List<List<BSTNode>> levelOrderTraversal(BSTNode node) {
        List<List<BSTNode>> result = new ArrayList<>();
        Queue<BSTNode> queue = new LinkedList<>();
        ((LinkedList<BSTNode>) queue).add(node);
        List<BSTNode> t = new ArrayList<>();
        t.add(node);
        int size = 0;
        result.add(t);
        while(!queue.isEmpty()) {
            List<BSTNode> temp = new ArrayList<>();
            size = queue.size();
            while(size > 0) {
                BSTNode cur = queue.poll();
                if(cur.leftChild != null) {
                    ((LinkedList<BSTNode>) queue).add(cur.leftChild);
                    temp.add(cur.leftChild);
                }
                if(cur.rightChild != null) {
                    ((LinkedList<BSTNode>) queue).add(cur.rightChild);
                    temp.add(cur.rightChild);
                }
                size--;
            }
            result.add(temp);
        }
        return result;
    }


    public static void main(String[] args) {
        BSTClass bs = new BSTClass();
        bs.root = new BSTNode(8);
        root.leftChild = new BSTNode(4);
        root.leftChild.leftChild = new BSTNode(3);
        root.leftChild.rightChild = new BSTNode(7);
        root.rightChild = new BSTNode(11);
        root.rightChild.leftChild = new BSTNode(10);

        System.out.println(bs.levelOrderTraversal(root));

    }
}
