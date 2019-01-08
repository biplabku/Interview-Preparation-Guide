import java.util.Stack;

public class MinStackNext {
        int min = Integer.MAX_VALUE;

        Stack<Integer> thestack;

        public MinStackNext(){
            thestack=new Stack<>();
        }

        // 5 - 4 -1 -2
        public void push(int x) {
            if(x <= min) {
                thestack.push(min);
                min = x;
            }
            thestack.push(x);
        }

        public void pop() {
            if(thestack.pop() == min) {
                min = thestack.pop();
            }

        }

        public int top() {
            return thestack.peek();
        }


        public int getMin() {
            return min;
        }

        public static void main(String[] args) {
            // 5-1-2-4-3
            MinStackNext ms = new MinStackNext();
            ms.push(5);
            ms.push(1);
            ms.push(2);
            ms.push(3);
            ms.push(0);
            //ms.pop();
            System.out.println(ms.getMin());
        }
}
