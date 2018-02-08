public class fibonacci {



    public static int getFibonaciMethod1(int number) {
        if(number == 0 || number == 1) {
            return 1;
        }
        return getFibonaciMethod1(number - 1)  + getFibonaciMethod1(number - 2);
    }

    public static void main(String[] args) {

        int number = 9;
        System.out.println(getFibonaciMethod1(5));
    }
}
