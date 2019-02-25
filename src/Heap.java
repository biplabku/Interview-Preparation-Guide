public class Heap {

    private HeapNode[] heapArray;
    private int maxSize;
    private int curSize;

    public Heap(int size) {
        maxSize = size;
        curSize = 0;
        heapArray = new HeapNode[size];
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean insert(int val) {
        if(curSize == maxSize) {
            return false;
        }
        HeapNode node = new HeapNode(val);
        heapArray[curSize] = node;
        curSize++;
        trickleUp(curSize);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1)/2;
        HeapNode bottom = heapArray[index];
        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1)/2;
        }
        heapArray[index] = bottom;
    }

    public HeapNode remove() {
        HeapNode root = heapArray[0];
        heapArray[0] = heapArray[--curSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        HeapNode top = heapArray[index];
        while(index < curSize) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if(rightChild < curSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            }else {
                largerChild = leftChild;
            }
            if(top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public static class HeapNode{
        private int data;

        public HeapNode(int key) {
            data = key;
        }

        public int getKey() {
            return data;
        }

        public void setKey(int id) {
            data = id;
        }
    }

    public static void main(String[] args) {

    }
}
