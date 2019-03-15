public class TreeProblems {

    //        3
    //     9        20
    //           15    7
    // preorder = [3,9,20,15,7]  root left right
    // inorder =  [9,3,15,20,7]  left root right
    public TreeNode buildTree(int[] preorder, int [] inorder) {
        TreeNode root = addNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.leftChild);
            System.out.println(root.data);
            inOrder(root.rightChild);
        }
    }

    public TreeNode addNode(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if(prestart > preend) {
            return  null;
        }
        if(prestart == preend) {
            return new TreeNode(preorder[prestart]);
        }
        int idx = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[prestart]) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[idx]);
        root.leftChild = addNode(preorder, prestart + 1,
                idx - instart + prestart, inorder, instart, idx - 1);
        root.rightChild = addNode(preorder, idx - instart + prestart + 1, preend,
                inorder, idx + 1, inend);
        return root;
    }



    public static void main(String[] args) {
        int[] arr = {3,9,20,15,7};
        int[] arr2 = {9,3,15,20,7};
        TreeProblems ts = new TreeProblems();
        System.out.println(ts.buildTree(arr, arr2));
    }
}
