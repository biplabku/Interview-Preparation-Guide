public class powerOfTwo {


    public static boolean getPowerOfTwo(int number) {
        if(number == 1 || number == 2) {
            return true;
        }
        int prev = 1;
        int out = 1;
        while(prev < number) {
            out = 2 * prev;
            prev = out;
            if(out == number) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 2147483647s;
        System.out.println(getPowerOfTwo(number));
    }
}
