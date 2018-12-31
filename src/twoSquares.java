public class twoSquares {

    // given a number, check whether if 2 numbers exist whose addition of square
    // is equal to the number

    public boolean isTwoSquare1(int number) {
        int leftIndex = 0;
        int rightIndex = (int)Math.sqrt(number);
        while(leftIndex <= rightIndex) {
            int sum = leftIndex * leftIndex + rightIndex * rightIndex;
            if(sum < number) {
                leftIndex++;
            }else if(sum > number) {
                rightIndex--;
            }else {
                return true;
            }
        }
        return false;
    }

    public boolean isTwoSquare(int number) {
        //
        for(int i = 1; i <= number; i++) {
            for(int j = i; j <= number; j++) {
                int result = i * i + j * j;
                if(result == number) {
                    return true;
                }else if(result > number) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        twoSquares ts = new twoSquares();
        System.out.println(ts.isTwoSquare1(4));
    }
}
