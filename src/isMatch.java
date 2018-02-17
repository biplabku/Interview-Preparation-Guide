public class isMatch {

    // the algorithm is to start from the left and move towards left from there on
    public static boolean isMatch(String str1, String str2){
        int count1 = str1.length() - 1;
        int count2 = str2.length() - 1;
        if(count1 <= 0 || count2 <= 0) {
            return true;
        }
        while(count1 != 0 && count2 != 0) {
            if(str1.charAt(count1) == '*' || str2.charAt(count2) == '*') {
                return true;
            }else if(str1.charAt(count1) != '*' && str2.charAt(count2) != '*') {
                if(str1.charAt(count1) == '.' || str2.charAt(count2) == '.' || (str1.charAt(count1) == str2.charAt(count2))) {
                    count1--;
                    count2--;
                }else {
                    return false;
                }
            }
        }
        return (count1 == 0 && count2 == 0);
    }

    public static void main(String[] args) {
        String str1 = "";
        String str2 = ".*";
        System.out.println(isMatch(str1,str2));
    }
}
