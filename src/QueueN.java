public class QueueN {

    // implement Queue
    // first in first out (FIFO)

    int rear;
    int front;
    int capacity;
    int[] myQueue;

    // default constructor initializing all the required fields
    public QueueN(int val) {
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

    public static void main(String[] args) {
        QueueN qu = new QueueN(5);
        qu.enQueue(3);

        qu.enQueue(2);
        qu.enQueue(1);
        qu.enQueue(9);
        qu.enQueue(8);

        qu.display();
        qu.deQueue();
        qu.display();
        System.out.println(qu.isEmpty());
    }

}
