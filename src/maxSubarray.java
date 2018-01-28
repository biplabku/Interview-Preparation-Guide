public class maxSubarray {

    public static int findMaxSubarray(int[] array) {
        int maxSumSoFar=0;
        for(int i = 0; i < array.length; i++){
            int sum = 0;
            for(int j = i; j < array.length; j++) {
                sum += array[j]; //sum is that of A[i..j]
                if (sum > maxSumSoFar) {
                    maxSumSoFar = sum;
                }
            }
        }
        return maxSumSoFar;
    }

    public static void main(String[] args) {
        int[] array = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMaxSubarray(array));
    }
}
