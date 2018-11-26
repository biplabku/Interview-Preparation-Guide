import java.util.ArrayList;

public class longCommPrefix {

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

    public static void main(String[] args) {
        longCommPrefix ms   = new longCommPrefix();
        ArrayList<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("abcd");
        list.add("abgh");
        System.out.println(ms.longCommPrefix(list));

    }

}
