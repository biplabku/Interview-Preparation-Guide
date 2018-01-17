import java.util.Arrays;

public class MinHeap {

    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    private int getparentIndex(int childIndex) {
        return (childIndex - 1)/2;
    }

    private int getLeftChild(int parentIndex) {
        return items[getLeftChildIndex(parentIndex)];
    }
    private int getRightChild(int parentIndex) {
        return items[getRightChildIndex(parentIndex)];
    }
    private int getParent(int childIndex) {
        return items[getparentIndex(childIndex)];
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }
    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }
    private boolean hasParent(int childIndex) {
        return getparentIndex(childIndex) >= 0;
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && getParent(index) > items[index]) {
            swap(getparentIndex(index), index);
            index = getparentIndex(index);
        }
    }

    public void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void ensureCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if(size == 0) {
            throw new IllegalStateException();
        }else {
            return items[0];
        }
    }


    public int poll() {
        if(size == 0)  throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }


    public void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasLeftChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] < items[smallerChildIndex]) {
                break;
            }else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }































}
