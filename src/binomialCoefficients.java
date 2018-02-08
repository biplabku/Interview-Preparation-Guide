public class binomialCoefficients {


    public static int getBinomial(int number, int k) {
        int[][] bc = new int[number + 1][number + 1];
        for(int i = 0 ; i <= number; i++) {
            bc[i][0] = 1;
        }
        for(int j = 0 ; j <= number; j++) {
            bc[j][j] = 1;
        }
        for(int  i = 1; i <= number; i++ ) {
            for(int j = 1; j <= number; j++ ) {
                bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
            }
        }
        return bc[number][k];

    }

    public static void main(String[] args) {
        int number = 4;
        int  k = 2;
        System.out.println(getBinomial(number, k));
    }
}
