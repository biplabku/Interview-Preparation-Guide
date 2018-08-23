import java.util.ArrayList;

public class priorityQueue {

    // priority queue can be ascending and descending type.
    // min key having the highest priority   - ascending
    // max key having the highest priority   - descending

    // mai priority key operations
    // insert (kye, data) - inserts data with key to the priority key. Elements are ordered based on key
    // deletemin/deletemax - Remove and return the element with the largest/smallest key
    // getMin/Getmax - Return the element with the smallest/largest key without deleting it

    // get the latest minimum element
    // Use the queue code already present
    int rear;
    int front;
    int capacity;
    int[] myQueue;

    public priorityQueue(int val) {
        rear = -1;
        front = 0;
        myQueue = new int[val];
        capacity = val;
    }

    public void enQueue(int item) {
        myQueue[++rear] = item;
        if(rear > capacity) {
            throw new IndexOutOfBoundsException("Capacity is reached");
        }

    }

    public int deQueue() {
        if(front > rear) {
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        int el = myQueue[front];
        front++;
        return el;
    }

    public void display() {
        for(int i = front ; i <= rear; i++) {
            System.out.println(myQueue[i]);
        }
    }

    public boolean isEmpty() {
        if(front > rear) {
            return true;
        }
        return false;
    }

    //implmenting maxHeap
    // it will be same as priority queue




    public static void main(String[] args) {
        priorityQueue qu = new priorityQueue(7);
        qu.enQueue(5);
        qu.enQueue(1);
        qu.enQueue(2);
        qu.enQueue(6);
        qu.enQueue(1);
        qu.enQueue(9);
        qu.enQueue(0);

        qu.display();
    }


}
