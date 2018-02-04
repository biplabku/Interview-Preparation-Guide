public class magicIndex {



    public static int getMagicIndex(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,4,6,7,9,11};
        System.out.println(getMagicIndex(array));
    }
}
