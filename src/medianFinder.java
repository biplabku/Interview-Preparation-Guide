import java.util.*;

public class medianFinder {

    List<Integer> queue;
    int[] array ;
    int size ;
    public medianFinder() {
        queue = new ArrayList<>();
        size = 0;
        array = new int[10];
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
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

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;



    public void addNum1(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if(minHeap.size() < maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian1() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }


    PriorityQueue<Integer> lowers = new PriorityQueue<>();
    PriorityQueue<Integer> higher = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void addValue(int num) {
        if(lowers.size() == 0 || num < lowers.peek()) {
            lowers.add(num);
        }else {
            higher.add(num);
        }
        balance(lowers, higher);
    }

    public void balance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> bigger = lowers.size() > higher.size() ? lowers:higher;
        PriorityQueue<Integer> smaller = lowers.size() > higher.size() ? higher:lowers;

        if(bigger.size() - smaller.size() >= 2) {
            smaller.add(bigger.poll());
        }
    }

    public double getMedianUsingHeap() {
        PriorityQueue<Integer> small = lowers.size() < higher.size() ? higher:lowers;
        PriorityQueue<Integer> large = lowers.size() > higher.size() ? lowers:higher;

        if(small.size() == large.size()) {
            return (double) (small.peek() + large.peek())/2;
        }else {
            return (double) large.peek();
        }
    }

    public static void main(String[] args) {
        medianFinder ms = new medianFinder();
        ms.addValue(7);
        System.out.println(ms.getMedianUsingHeap());
        ms.addValue(6);
        System.out.println(ms.getMedianUsingHeap());
        ms.addValue(4);
        System.out.println(ms.getMedianUsingHeap());
    }

}
