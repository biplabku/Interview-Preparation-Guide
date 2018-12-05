public class ConvertToInt {

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

    public static void main(String[] args) {
        ConvertToInt conve = new ConvertToInt();
        String str = "-54332872018247709407 4 54";
        System.out.println(conve.converToInt(str));
    }

}
