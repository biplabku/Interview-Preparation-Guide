import java.util.Stack;

public class redundantBraces {


    // ((a + b)) has redundant braces so answer will be 1
    // (a + (a + b)) doesn't have have any redundant braces so answer will be 0

    public boolean checkRedundancy(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(ch == ')') {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '(') return true;
                int elementInside = 0;
                while(stack.pop() != '(') {
                    elementInside++;
                    stack.pop();
                }
                stack.pop();
                if(elementInside < 2) {
                    return false;
                }

            }else{
                stack.push(ch);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "((a+ b))";
        redundantBraces rs = new redundantBraces();
        System.out.println(rs.checkRedundancy(str));
    }
}
