import java.util.ArrayList;
import java.util.Arrays;

public class longCommPrefix {

    // completing the implementation for finding the long common prefix among the list of strings
    // Comparing it with the first string everytime for all the strings
    // Time complexity - O(N2)
    //
    public  String longCommPrefix1(ArrayList<String> str) {
        StringBuilder finalR = new StringBuilder();
        for(int i = 0; i < str.size(); i++) {
            for(int j = i; j < str.size(); j++) {
                String first = str.get(i);
                String second = str.get(j);
                if(first.charAt(i) != second.charAt(i)) {
                    return finalR.toString();
                }
            }
            finalR.append(str.get(i).charAt(i));
        }
        return finalR.toString();
    }

    public  String longCommPrefix(ArrayList<String> str) {
        int count = 0;
        int k = 0;
        StringBuilder finalR = new StringBuilder();
        for(int i = 0; i < str.size(); i++) {
            for(int j = i + 1; j < str.size(); j++) {
                String f = str.get(i);
                String s = str.get(j);
                Character first = str.get(i).charAt(i);
                Character second = str.get(j).charAt(i);
                if(str.get(i).charAt(i) == str.get(j).charAt(i)) {
                    count = j;
                    continue;

                }else {
                    break;
                }
            }
            if(count == str.size() - 1) {
                k++;
                finalR.append(str.get(i).charAt(k - 1));
            }else {
                return finalR.toString();
            }
        }
        return finalR.toString();
    }


    public String longCommonPrefix(ArrayList<String> list) {
        if(list.size() == 1) {
            return list.get(0);
        }
        int len = Integer.MAX_VALUE;
        for(int k = 0; k < list.size(); k++) {
            len = Math.min(list.get(k).length(), len);
        }
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < list.size() - 1; j++) {
                String left = list.get(j);
                String right = list.get(j + 1);
                if((i >= left.length()) || (i >= right.length())) {
                    return finalString.toString();
                }
                if(left.charAt(i) != right.charAt(i)) {
                    return finalString.toString();
                }
            }
            finalString.append(list.get(i).charAt(i));
        }
        return finalString.toString();
    }

    public String longestCommonPrefix(ArrayList<String> A) {
        if (A == null || A.size() == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (String S : A) {
            if (S == null || S.length() == 0) {
                return null;
            }
            if (S.length() < minLen) {
                minLen = S.length();
            }
        }
        System.out.println(minLen);
        for (int j = 0; j < minLen; j++) {
            int count = 0;
            char c = A.get(0).charAt(j);
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i).charAt(j) != c){
                    break;
                }
                count++;
            }
            if (count != A.size()){
                return sb.toString();
            }
            sb.append(c);
        }

        return sb.toString();
    }



    public static void main(String[] args) {
        longCommPrefix ms   = new longCommPrefix();
        String[] array = new String[]{
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" };

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));

        System.out.println(ms.longestCommonPrefix(list));

    }

}
