import java.util.Arrays;

public class validAnagram {


    public static boolean isValidAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        String s1 =  new String(a);
        String s2 = new String(b);
        System.out.println(s1 + " " + s2);
        return s1.equals(s2);
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isValidAnagram(s, t));

    }
}
