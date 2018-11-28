import java.util.ArrayList;

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
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size() - 1; j++) {
                String left = list.get(j);
                String right = list.get(j + 1);
                if(left.charAt(i) != right.charAt(i)) {
                    return finalString.toString();
                }
            }
            finalString.append(list.get(i).charAt(i));
        }
        return finalString.toString();
    }



    public static void main(String[] args) {
        longCommPrefix ms   = new longCommPrefix();
        ArrayList<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("abde");
        list.add("abch");
        System.out.println(ms.longCommonPrefix(list));

    }

}
