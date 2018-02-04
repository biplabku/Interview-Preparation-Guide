public class magicIndex {



    public static int getMagicIndex(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int getMagic(int[] array) {
        return getMagicIndexRepeat(array, 0, array.length -1);
    }

    public static int getMagicIndexFast( int[] array, int low, int high) {
        if(low > high) {
            return -1;
        }
        int mid = (low + high)/2;
        if(array[mid] == mid) {
            return mid;
        }else if(array[mid] > mid) {
            return getMagicIndexFast(array, low, mid - 1);
        }else {
            return getMagicIndexFast(array, mid + 1, high);
        }
    }


    public static int getMagicIndexRepeat(int[] array, int low, int high) {
        if(low > high) {
            return  -1;
        }
        int midIndex = (low + high)/2;
        int midValue = array[midIndex];
        if(array[midIndex ]  == midValue) {
            return midIndex;
        }
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = getMagicIndexRepeat(array, low, leftIndex) ;
        if(left >= 0) {
            return left;
        }
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = getMagicIndexRepeat(array, rightIndex, high);
        return right;
    }

    public static void main(String[] args) {
        int[] array = new int[] {-40, -20, -1, 1,2,3,5,7,9,12,13 };
        System.out.println(getMagic(array));
    }
}
