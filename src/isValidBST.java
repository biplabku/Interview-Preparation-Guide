
public class isValidBST {


    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.leftChild.data > root.data || root.rightChild.data < root.data) {
            return false;
        }
        return (isValidBST(root.leftChild) && isValidBST(root.rightChild));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        System.out.println(isValidBST(root));
    }
}
