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


    public static String CountAndSayMethod2(int number) {
        String str = formStringFromNumber(number);
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

    public static int getDigits(int number) {
        int length = String.valueOf(number).length();
        return length;
    }

    public static String formStringFromNumber(int number) {
        String str = "";
        int m = number;
        int a ;
        int count = getDigits(number);
        while(count > 0) {
            a = m % 10;
            str = str + a;
            m = m/10;
            count--;
        }
        String str1 = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            str1 = str1 + str.charAt(i);
        }
        return str1;
    }

    public static void main(String[] args) {
        String str = "123";
        int number  = 123;
        System.out.println(CountAndSay(str));
        System.out.println(CountAndSayMethod2(number));
    }
}
