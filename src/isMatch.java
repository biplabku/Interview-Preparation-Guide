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

        public boolean isMatch1(String s, String p) {

            if(p.length() == 0)
                return s.length() == 0;
            // condition when there is no match
            if(p.length() == 1 || p.charAt(1) != '*'){
                if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                    return false;
                return isMatch(s.substring(1), p.substring(1));

            }else{
                int len = s.length();

                int i = -1;
                while(i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                    if(isMatch(s.substring(i+1), p.substring(2)))
                        return true;
                    i++;
                }
                return false;
            }
        }


    public static void main(String[] args) {
        String str1 = "";
        String str2 = ".*";
        String st = "abcd";
        System.out.println(st.substring(1));
        System.out.println(isMatch(str1,str2));
    }
}
