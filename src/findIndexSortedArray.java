public class findIndexSortedArray {


    public static int findIndexSortedArray(int[] array, int leftIndex, int rightIndex, int target) {
        if(leftIndex > rightIndex) {
            return -1;
        }
        int mid = (leftIndex + (rightIndex - leftIndex))/2;
        if(array[mid] == target) {
            return mid;
        }
        findIndexSortedArray(array, leftIndex, mid, target) ;
        findIndexSortedArray(array, mid+1, rightIndex, target);
    }


    
    public static void main(String[] args) {
        int[] array = new int[] {4,5,6,7,0,1,2};
        System.out.println(findIndexSortedArray(array, 0, array.length-1, 1));
    }
}
