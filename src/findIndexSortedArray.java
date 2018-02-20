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
        return -1;
    }

    public static int findIndexArray(int[] array, int leftIndex, int rightIndex, int target) {
        while (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (array[mid] > array[rightIndex]) {  // eg. 3,4,5,6,1,2
                if (target > array[mid] || target <= array[rightIndex]) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid;
                }
            } else {  // eg. 5,6,1,2,3,4
                if (target > array[mid] && target <= array[rightIndex]) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid;
                }
            }
        }
        if (leftIndex == rightIndex && target != array[leftIndex]) return -1;
        return leftIndex;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,5,6,7,0,1,2};
        System.out.println(findIndexArray(array, 0, array.length-1, 1));
    }
}
