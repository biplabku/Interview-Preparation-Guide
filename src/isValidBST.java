import javax.xml.soap.Node;

public class isValidBST {


    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left.data > root.data || root.right.data < root.data) {
            return false;
        }
        return (isValidBST(root.left) && isValidBST(root.right));
    }

    public static void main(String[] args) {
        System.out.println(isValidBST(root));
    }
}
