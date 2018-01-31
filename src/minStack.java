import java.util.Stack;

public class minStack {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack.pop().value );
            System.out.println("New min is " + stack.min());
        }
    }

}
