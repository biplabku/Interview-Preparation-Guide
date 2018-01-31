public class mergeTrees {



    public TreeNode mergeTrees(TreeNode node1 , TreeNode node2) {
        if(node1 == null && node2 == null) {
            return null;
        }

        int val = (node1 == null ? null : node1.data) + (node2 == null ? null : node2.data);
        TreeNode n = new TreeNode(val);
        n.leftChild = mergeTrees((node1 == null ? null : node1.leftChild), (node2 == null ? null : node2.leftChild));
        n.rightChild = mergeTrees((node1 == null ? null : node1.rightChild), (node2 == null ? null : node2.rightChild));
        return n;
    }

    public static void main(String[] args) {

    }
}
