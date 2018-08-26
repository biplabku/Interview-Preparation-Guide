import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String first = o1 + o2;
        String second = o2 +  o1;
        return second.compareTo(first);
    }
}

public class largestInteger {
    // Given a list of non negative integers, arrange them such that they form the largest number.
    // For example:
    // Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
    // Note: The result may be very large, so you need to return a string instead of an integer.

    public String getLargestInteger(ArrayList<Integer> list) {
        ArrayList<String> str = new ArrayList<>();
        for(Integer i : list) {
            str.add(String.valueOf(i));
        }
        Collections.sort(str, new MyComparator());
        System.out.println(str);
        StringBuilder strBuild = new StringBuilder();
        for(String s : str) {
            if("0".equals(s) && strBuild.length() != 0) {
                continue;
            }
            strBuild.append(s);
        }
        return strBuild.toString();
    }



    public static void main(String[] args) {
        largestInteger ls = new largestInteger();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(30);
        list.add(34);
        list.add(5);
        list.add(9);
        System.out.println(ls.getLargestInteger(list));
    }
}
