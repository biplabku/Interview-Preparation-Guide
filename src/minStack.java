public class minStack {
    int curSize ;
    int[] array;
    int maxsize;
    int min;

    public minStack(int value) {
        maxsize = value;
        array = new int[maxsize];
        curSize = -1;
        min = 0;
    }

    public int push(int val) {
        if(isEmpty()) {
            min = val;
        }else {
            if(peek() > val) {
                min = val;
            }
        }
        array[++curSize] = val;
        return val;
    }

    public int peek() {
        return array[curSize];
    }

    public int pop() {
        int val = array[curSize];
        curSize--;
        return val;
    }

    public int getMin() {
       return min;
    }

    public boolean isEmpty() {
        if(curSize == -1 ) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        minStack thestack = new minStack(5);
        thestack.push(5);
        thestack.push(4);
        thestack.push(1);
        thestack.push(3);
        thestack.push(9);
        System.out.println(thestack.getMin());
    }
}
