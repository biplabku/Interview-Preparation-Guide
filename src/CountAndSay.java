public class CountAndSay {


    public static String CountAndSay(String str) {
        StringBuilder sb = new StringBuilder();
        if(str.length() == 1) {
            sb.append(1);
            sb.append(str.charAt(0));
            return sb.toString();
        }
        int count = 1;
        for(int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                count++;
            }else {
                sb.append(count);
                sb.append(str.charAt(i));
                count = 1;
            }
        }
        if(str.charAt(str.length() - 1) == str.charAt(str.length() - 2)) {
            sb.append(count);
            sb.append(str.charAt(str.length() - 1));
        }else {
            sb.append(1);
            sb.append(str.charAt(str.length() - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "1212";
        System.out.println(CountAndSay(str));
    }
}
