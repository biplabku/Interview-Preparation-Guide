import java.util.*;

public class medianFinder {

    List<Integer> queue;
    int[] array ;
    int size ;
    public medianFinder() {
        queue = new ArrayList<>();
        size = 0;
        array = new int[10];
    }

    public void addNum(int num) {
        queue.add(num);
        Collections.sort(queue);    }

    public double findMedian() {
        int size = queue.size();
        if(size % 2 != 0) {
            return queue.get(size/2);
        }

        int left = queue.get(size/2);
        int right = queue.get(size/2 - 1);
        return (double) (left + right)/2;
    }

    // Creating MinHeap implementation
    public void insertNum(int num) {
        ensureCapacity();
        array[size] = num;
        size++;
        moveUp();
    }

    public void moveUp() {
        int parentIndex = (size-1)/2;
        int currentIndex = size - 1;
        while(currentIndex > 0 && array[parentIndex] > array[currentIndex] ) {
            swap(parentIndex, currentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex/2;
        }
    }

    public void swap(int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public void ensureCapacity() {
        if(size == array.length) {
            array = Arrays.copyOf(array, 2 * size);
        }
    }

    public double findMedianFast() {
        if(size % 2 != 0) {
            return array[size/2];
        }

        int left = array[size/2];
        int right = array[size/2 - 1];
        return (double) (left + right)/2;
    }


    public static void main(String[] args) {
        medianFinder ms = new medianFinder();
        ms.insertNum(7);
        System.out.println(ms.findMedianFast());
        ms.insertNum(6);
        System.out.println(ms.findMedianFast());
        ms.insertNum(4);
        System.out.println(ms.findMedianFast());
    }

}
