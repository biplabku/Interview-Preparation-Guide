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

    // Level order traversal.
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





    public boolean regularExpression(String string, String pattern) {
        int index1 = string.length() - 1;
        int index2 = pattern.length() - 1;

        while(index1 >= 0 && index2 >= 0) {
            if(pattern.charAt(index2) == '*') {
                index2--;
                if(pattern.charAt(index2) == '.') {
                    index1 = 0;
                    index2 = 0;
                }else { // if the previous character of pattern is a letter
                    char ch = pattern.charAt(index2); // a*
                    if(ch == string.charAt(index1)) {
                        index1--;
                    }else {
                        return false;
                    }
                }
            }else if(pattern.charAt(index2) == '.') {
                index2--;
                index1--;
            }else if(pattern.charAt(index2) == string.charAt(index1)) {
                index1--;
                index2--;
            }else {
                return false;
            }
        }

        if(index1 == 0 && index2 != 0 || index1 != 0 && index2 == 0) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        BSTClass bs = new BSTClass();
        bs.root = new BSTNode(8);
        root.leftChild = new BSTNode(4);
        root.leftChild.leftChild = new BSTNode(3);
        root.leftChild.rightChild = new BSTNode(7);
        root.rightChild = new BSTNode(11);
        root.rightChild.leftChild = new BSTNode(10);

        System.out.println(bs.regularExpression("aaa", "ab*ac*a"));

    }
}
