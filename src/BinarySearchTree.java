public class BinarySearchTree {

    public BSTNode root;
    public int nelms;

    public BinarySearchTree() {
        root= null;
        nelms = 0;
    }


    public void insertNode(int val, BSTNode  cur) {
        if(root == null) {
            root = new BSTNode(val);
        }else {
            if(cur.data <= val) {
                insertNode(val, cur.rightChild);
            }else {
                insertNode(val, cur.leftChild);
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
