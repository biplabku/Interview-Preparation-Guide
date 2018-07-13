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

    public int getMaxHeight() {
        return -1;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void inOrderTraversal(TreeNode node) {
        if(node != null) {
            System.out.println(node.data);
            inOrderTraversal(node.leftChild);
            inOrderTraversal(node.rightChild);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bs = new BinarySearchTree();
        bs.insertNode(12);
        bs.insertNode(8);
        bs.insertNode(7);
        bs.insertNode(9);
        bs.insertNode(18);
        bs.insertNode(15);
        bs.insertNode(13);
        bs.inOrderTraversal(bs.root);
    }

}
