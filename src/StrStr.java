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
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < max; i++) {
            
        }
    }

    public static void main(String[] args) {
        StrStr str = new StrStr();
        String A = "b";
        String B = "b";
        System.out.println(str.getStrStr(A, B));
    }
}
