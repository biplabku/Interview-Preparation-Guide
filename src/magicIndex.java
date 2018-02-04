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
        return getMagicIndexFast(array, 0, array.length -1);
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

    public static void main(String[] args) {
        int[] array = new int[] {-40, -20, -1, 1,2,3,5,7,9,12,13 };
        System.out.println(getMagic(array));
    }
}
