public class StrStr {

    public int getStrStr(String str, String otherStr) {

        for(int i = 0; i < (str.length() - otherStr.length()) + 1; i++) {
            if(str.substring(i, i + otherStr.length()).equalsIgnoreCase(otherStr)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr str = new StrStr();
        String A = "b";
        String B = "b";
        System.out.println(str.getStrStr(A, B));
    }
}
