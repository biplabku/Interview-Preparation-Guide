public class minStackWithoutModifying {

    int curSize = 0;
    int size = 4;
    int[] array ;
    int min ;
    public minStackWithoutModifying(int val) {
        array = new int[size];
        min = Integer.MAX_VALUE;
        curSize = 0;
    }

    public boolean isEmpty() {
        if(curSize == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(curSize == size - 1) {
            return true;
        }
        return false;
    }

    public void push(int x) {
        if(!isEmpty() || !isFull()) {        // if its not empty
            array[curSize] = x;
            if(min > x) {
                min = Math.min(x, min);
            }
            curSize++;
        }else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if(!isEmpty()) {
            int val = array[curSize - 1];
            curSize--;
            updateMin();
            return val;
        }
        return-1;
    }

    public void updateMin() {
        min = array[curSize - 1];
        for(int i =0; i < curSize; i++) {
            min = Math.min(min, array[i]);
        }
    }

    public int getMin() {
        return min;
    }

    public int peek() {
        if(!isEmpty()) {
            return array[curSize];
        }
        return -1;
    }

    public void display() {
        for(int i =0; i < curSize; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        minStackWithoutModifying ms = new minStackWithoutModifying(4);
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(0);
        ms.display();
        ms.pop();
        System.out.println(ms.getMin());
    }
}
