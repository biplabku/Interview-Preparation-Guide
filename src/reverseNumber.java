public class reverseNumber {


    public int getReverseNumber(int number) {
        if(number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
            return 0;
        }

        int temp = Math.abs(number);
        long result = 0;

        while(temp != 0) {
            result = result * 10 + temp % 10;
            temp = temp/10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)(number < 0 ? -result : result);
    }

    public static void main(String[] args) {
        reverseNumber rs = new reverseNumber();
        int number = 120;
        System.out.println(Math.abs(number));
        System.out.println(rs.getReverseNumber(number));
    }
}
