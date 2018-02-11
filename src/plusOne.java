import java.util.ArrayList;
import java.util.LinkedList;

public class plusOne {

    public static LinkedList<Integer> getPlusOne(int[] digits) {
        LinkedList<Integer> list  = new LinkedList<>();
        int add = 1;
        int sum = 0;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0 ; i--) {
            sum = digits[i] + add + carry;
            if(sum > 9) {
                list.addFirst(sum%10);
                carry = sum/10;
            }else {
                list.addFirst(sum);
                carry = 0;
            }
        }
        if(carry > 0) {
            list.addFirst(carry);
        }
        return list;
    }

    public static int[] getPlusOneMethod1 (int[] digits) {
        for(int i = digits.length - 1; i >= 0 ; i--) {
            if(digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] out = new int[digits.length + 1];
        out[0] = 1;
        return  out;
    }


    public static void main(String[] args) {
        int [] digit = new int[] {9,9,9} ; // 1 -- 2 -- 3
        System.out.println(getPlusOne(digit));
        System.out.println(getPlusOneMethod1(digit));
    }
}
