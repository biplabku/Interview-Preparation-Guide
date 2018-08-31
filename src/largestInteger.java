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
        StringBuilder strBuild = new StringBuilder();
        for(String s : str) {
            if("0".equals(s) && strBuild.length() != 0) {
                continue;
            }
            strBuild.append(s);
        }
        return strBuild.toString();
    }

    // number of times repeated comes first and then the actual number
    public int getLargestInteger(int number) {
        if(number == 1) {
            return 1;
        }
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i - 1)) {
                count++;
            }else {
                sb.append(count);
                sb.append(str.charAt(i - 1));
                count = 1;
            }
        }
        if(count == 1) {
            sb.append(count);
            sb.append(str.charAt(str.length() - 1));
        }else {
            sb.append(count);
            sb.append(str.charAt(str.length() - 1));
        }
        return  Integer.valueOf(sb.toString());
        // getting the size of number
    }




    public static void main(String[] args) {
        largestInteger ls = new largestInteger();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        System.out.println(ls.getLargestInteger(list));
        // System.out.println(ls.getLargestInteger(31));
    }
}
