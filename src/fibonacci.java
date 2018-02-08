public class fibonacci {



    public static int getFibonaciMethod1(int number) {
        if(number == 0 || number == 1) {
            return 1;
        }
        return getFibonaciMethod1(number - 1)  + getFibonaciMethod1(number - 2);
    }

    public static int getFibonaciMethod2(int number) {
        if(number == 0 || number == 1) {
            return 1;
        }
        int[] fib = new int[number + 1];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i <= number; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[number];
    }


    public static void main(String[] args) {

        int number = 5;
        System.out.println(getFibonaciMethod1(number));
        System.out.println(getFibonaciMethod2(number));
    }
}
