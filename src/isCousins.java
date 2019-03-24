import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class isCousins {
    public boolean isCousins1(TreeNode root, int x, int y) {
        List<Integer> list = new ArrayList<>();
        getChild(root, x, 0, list);
        getChild(root, y, 0, list);
        List<Integer> list2 = new ArrayList<>();
        getParent(root.leftChild, x, list2);
        getParent(root.rightChild, y, list2);
        if(list.get(0) == list.get(1) && (list2.get(0) != list2.get(1))) {
            return true;
        }
        return false;
    }

    public void getChild(TreeNode root, int target, int level, List<Integer> list) {
        if(root == null) {
            return ;
        }
        if(root.data == target) {
            list.add(level);
        }
        getChild(root.leftChild, target, level + 1, list);
        getChild(root.rightChild, target, level + 1, list);
    }

    public void getParent(TreeNode root, int target, List<Integer> list) {
        if(root == null) {
            return ;
        }
        if(root.leftChild != null && root.leftChild.data == target) {
            list.add(root.data);
        }else if(root.rightChild != null && root.rightChild.data == target) {
            list.add(root.data);
        }
        getParent(root.leftChild, target, list);
        getParent(root.rightChild, target, list);
    }

    class Pair {
        TreeNode p;
        int level = -1;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Pair p1 = new Pair(), p2 = new Pair();
        recur(root, x, 0, p1);
        recur(root, y, 0, p2);
        return p1.level > 0 && p1.level == p2.level && p1.p != p2.p;
    }

    void recur(TreeNode node, int x, int level, Pair p) {
        if (node == null) return;
        if (node.data == x) p.level = level + 1;

        if (p.level < 0) {
            p.p = node;
            recur(node.leftChild, x, level + 1, p);
        }
        if (p.level < 0) {
            p.p = node;
            recur(node.rightChild, x, level + 1, p);
        }
    }

    public static void main(String[] args) {
        isCousins ls = new isCousins();
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.rightChild.leftChild = new TreeNode(4);
        // root.rightChild.rightChild = new TreeNode(7);
        System.out.println(ls.isCousins(root, 4, 3));
    }
}
