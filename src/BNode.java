public class BNode {

    public BNode leftChild;
    public BNode rightChild;
    public int data;

    public BNode(int val) {
        data = val;
        leftChild = null;
        rightChild = null;
    }


    public static class BinaryST {
        public BNode root;

        public BinaryST() {
            root = null;
        }

        public boolean checkBST(BNode node, int min, int max) {
            if(node == null) {
                return true;
            }
            if(node.data <= min || node.data >= max) {
                return false;
            }
            return checkBST(node.leftChild, min, node.data) && checkBST(node.rightChild, node.data, max);
        }

        public static void main(String[] args) {
            BinaryST bst = new BinaryST();
            BNode b1 = new BNode(7);
            BNode b2 = new BNode(4);
            b1.leftChild = b2;
            BNode b3 = new BNode(5);
            b2.rightChild = b3;

            BNode b4 = new BNode(8);
            BNode b5 = new BNode(9);
            b1.rightChild = b4;
            b4.rightChild = b5;
        }
    }
}
