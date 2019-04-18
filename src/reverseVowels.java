import java.util.ArrayList;

public class reverseVowels {

    public static String reverseVowels(String s) {
        char[] array = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>() ;
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = array[left];
            char r = array[right];
            if (list.contains(l) && list.contains(r)) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            } else if (list.contains(l) && !list.contains(r)) {
                right--;
            } else if (!list.contains(l) && list.contains(r)) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        s = new String(array);
        return s;
    }


    public static void main(String[] args) {
        String s = "aA";
        System.out.println(reverseVowels(s));
    }
}