import java.util.ArrayList;

public class productOfArray {

    public static ArrayList<Integer> getProductOfArray(int[] array) {
        int mul = 1;
        for(int i = 0; i < array.length; i++) { // O(N) // O(1)
            if(array[i] == 0 ) {
                mul = mul * 1;
            }else {
                mul = mul * array[i];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {  // O(N) // O(N)
            if(array[i] == 0) {
                list.add(mul/1);
            }else{
                list.add(mul/array[i]);
            }
        }
        return list;
    }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];


        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        return productsOfAllIntsExceptAtIndex;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,7,0,4};
        System.out.println(getProductOfArray(array));
        System.out.println(getProductsOfAllIntsExceptAtIndex(array));

    }
}
