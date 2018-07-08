public class BSTNode<T> {

    public T data;
    public BSTNode<T> leftChild;
    public BSTNode<T> rightChild;

    public  BSTNode(T value) {
        data = value;
        leftChild = null;
        rightChild = null;
    }
}
