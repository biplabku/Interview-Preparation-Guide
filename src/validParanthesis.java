import java.util.Stack;

public class validParanthesis {


    public static boolean findValidParanthesis(String str) {
        Stack<Character> theStack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                theStack.push(')');
            }else if(str.charAt(i) == '{') {
                theStack.push('}');
            }else if(str.charAt(i) == '[') {
                theStack.push(']');
            }else if(theStack.isEmpty() || theStack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return theStack.isEmpty();
    }

    public static void main(String[] args) {

        String str = "";
        System.out.println(findValidParanthesis(str));
    }
}
