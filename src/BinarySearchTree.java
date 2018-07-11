public class BinarySearchTree {

    public TreeNode root;
    public int nelms;

    public BinarySearchTree() {
        root= null;
        nelms = 0;
    }


    public void insertNode(int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) {
            root = node;
        }else {
            TreeNode cur = root;
            TreeNode prev = null;
            while(cur != null) {
                prev = cur;
                if(node.data <= cur.data) {
                    cur = cur.leftChild;
                    if(cur == null) {
                        prev.leftChild = node;
                    }
                }else {
                    cur = cur.rightChild;
                    if(cur == null) {
                        prev.rightChild = node;
                    }
                }
            }
        }
    }


    public void inOrderTraversal(BSTNode node) {
        if(node != null) {
            System.out.println(node.data);
            inOrderTraversal(node.leftChild);
            inOrderTraversal(node.rightChild);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bs = new BinarySearchTree();
    }

}
