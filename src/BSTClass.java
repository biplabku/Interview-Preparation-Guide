public class BSTClass {

    public BSTNode root;

    public BSTClass() {
        root = null;
    }

    public void insertNode(int value) {
        if(root == null) {
            root.data = value;
            return;
        }
        BSTNode node = new BSTNode(value);
        BSTNode current = new BSTNode(root.data);
        if(current != null) {


        }
    }


    public static void main(String[] args) {
        BSTClass bs = new BSTClass();

    }
}
