public class ConvertToInt {

    public int convertToIntLeetcode(final String str) {
        String string = str.trim();
        if(string.length() == 0) {
            return 0;
        }
        if((Integer.valueOf(string.charAt(0)) < 47) || (Integer.valueOf(string.charAt(0)) > 57)) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < string.length(); i++) {
            if(Integer.valueOf(string.charAt(i)) > 47 && Integer.valueOf(string.charAt(i)) < 57) { // select only the numbers
                sb.append(string.charAt(i));
            }else if(string.charAt(i) == ' ' || (Integer.valueOf(string.charAt(0)) < 47) || (Integer.valueOf(string.charAt(0)) > 57)) {
                break;
            }else if(string.charAt(i) == '+' || string.charAt(i) == '-') {
                sb.append(string.charAt(i));
            }
        }
        System.out.println(sb.toString());
        return 1;
    }


    public int converToInt(final String str){
        if(str == null || str.length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            int val = Integer.valueOf(str.charAt(i));
            if(str.charAt(i) == ' ') {
                break;
            }else if(val > 47 && val < 58) {
                sb.append(str.charAt(i));
            }else if(str.charAt(i) == '+'){
                continue;
            }else if(str.charAt(i) == '-') {
                sb.append(str.charAt(i));
            }
            else {
                break;
            }
        }
        int len = sb.toString().length();
        if(len == 0) {
            return 0;
        }
        if(sb.toString().charAt(0) == '-') {
            if(sb.length() == 1) {
                return 0;
            }
            if(Double.valueOf(sb.toString().substring(1, sb.length())) > Integer.MAX_VALUE) {
                return -Integer.MAX_VALUE;
            }else {
                return -Integer.valueOf(sb.toString().substring(1, sb.length()));
            }
        }
        if(Double.valueOf(sb.toString()) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return Integer.valueOf(sb.toString());
    }

    public int Convert(final String str) {
        StringBuilder sb = new StringBuilder();
        int lower  =47;
        int higher = 58;
        boolean neg = false;
        for(int i = 0; i < str.length(); i++) {
            int val = Integer.valueOf(str.charAt(i));
            if(val > lower && val < higher) {
                sb.append(str.charAt(i));
            }else if(str.charAt(i) == '+') {
                continue;
            }else if(str.charAt(i) == '-') {
                neg = true;
            }else {
                break;
            }
        }
        if(sb.length() == 0) {
            return 0;
        }
        if(neg) {
            if(sb.length() == 0) {
                return 0;
            }else if(Double.valueOf(sb.toString()) > Integer.MAX_VALUE) {
                return -(Integer.MAX_VALUE+1);
            }else {
                return -Integer.valueOf(sb.toString());
            }
        }
        if(Double.valueOf(sb.toString()) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE ;
        }
        return Integer.valueOf(sb.toString());
    }



    public static void main(String[] args) {
        ConvertToInt conve = new ConvertToInt();
        String str = "+12";
        // System.out.println(conve.converToInt(str));
        System.out.println(conve.convertToIntLeetcode(str));
    }

}
