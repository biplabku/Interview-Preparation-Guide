public class lowestComAncestor {

    public static Node findLowestCommAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        int value = root.data;
        if(value < node1.data && value < node2.data) {
            findLowestCommAncestor(root.leftChild, node1, node2);
        }else if{
            findLowestCommAncestor(root.rightChild, node1, node2);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(findLowestCommAncestor(12, 2, 3));
    }
}
