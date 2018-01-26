public class getDigits {


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

    public static void main(String[] args)  {
        int number = 13;
        System.out.println(getDigits(number));
        System.out.println(formStringFromNumber(123));
    }
}
