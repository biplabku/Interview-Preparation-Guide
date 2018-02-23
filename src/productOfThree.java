public class productOfThree {

    public static int getMaxProductOfThree(int[] array) {
        if(array.length < 3) {
            throw new IllegalArgumentException("Array length should be atleast 3");
        }
        int highest = Math.max(array[0], array[1]);
        int lowest = Math.min(array[0], array[1]);

        int highestProductOf2 = array[0] * array[1];
        int lowestProductOf2 = array[0] * array[1];

        int highestProductOf3 = array[2] * highestProductOf2;
        for(int i = 2; i < array.length; i++) {
            int current = array[i];

            highestProductOf3 = Math.max(highestProductOf3, current * highestProductOf2);

            highestProductOf2 = Math.max(highestProductOf2, highest * current);
            lowestProductOf2 = Math.min(lowestProductOf2, lowest * current);

            highest = Math.max(highest, current);
            lowest = Math.min(lowest, current);
        }
        return highestProductOf3;
    }

    public static void main(String[] args) {
        int[] array = new int[] {-10,10,1,2,3, 5};
        System.out.println(getMaxProductOfThree(array));
    }
}
