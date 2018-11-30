import java.util.ArrayList;

public class StrStr {

    public int getStrStr(String str, String otherStr) {

        for(int i = 0; i < (str.length() - otherStr.length()) + 1; i++) {
            if(str.substring(i, i + otherStr.length()).equalsIgnoreCase(otherStr)) {
                return i;
            }
        }
        return -1;
    }

    // StringoHolics implementation
    public int stringOHolics(ArrayList<String> list) {
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            max = Math.max(list.get(i).length(), max);
        }
        int val = 0;
        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            val = Math.max(getRotateString(str), val);
        }
        return val;
    }

    // generate all string after each step of rotation
    public int getRotateString(String str) {
        String origna = str;
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int val = 0;
        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(str.length() - 1));
            String st = str.substring(0, str.length() - 1);
            sb.append(st);
            list.add(sb.toString());
            if(sb.toString().equalsIgnoreCase(origna)) {
                return i;
            }
            str = sb.toString();

            sb.setLength(0);
        }
        return val;
    }

    public static void main(String[] args) {
        StrStr str = new StrStr();
        String A = "b";
        String B = "b";
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("ababa");
        list.add("aba");
        //System.out.println(str.getStrStr(A, B));
        // System.out.println(str.getRotateString("ABC"));
        System.out.println(str.stringOHolics(list));
    }
}
