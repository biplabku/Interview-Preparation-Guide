public class guessNumber {


    public static int guess(int number) {
        return 1;
    }

    public static int guessNumber(int number) {
        for(int i = 0; i < number; i++) {
            if(guess(i) == number) {
                return i;
            }
        }
        return number;
    }

    public static int guessNumberMethod2(int number) {
        int  low = 1;
        int high = number;
        while(low < high){
            int mid = (low + high)/2;
            if(guess(mid) == 0) {
                return mid;
            }else if(guess(mid) < 0) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
