public class lowestComAncestor {

    public static TreeNode findLowestCommAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        int value = root.data;
        if(value > node1.data && value > node2.data) {
            findLowestCommAncestor(root.leftChild, node1, node2);
        }else if(value < node1.data && value < node2.data){
            findLowestCommAncestor(root.rightChild, node1, node2);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        System.out.println(findLowestCommAncestor(root, node1, node2));
    }
}
