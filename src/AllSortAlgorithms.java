public class AllSortAlgorithms implements SortingAlgorithms {

    public int[] array = new int[] {5,4,3,2,8,7,6,9,0};


    // Bubble sort - Time Complexity O(N2)
    public void BubbleSort() {
        int temp = 0;
        for(int i= 0; i < array.length; i++) {
            for(int j = i + 1 ; j < array.length; j++) {
                if(array[i] > array[j] ) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void SelectionSort(){

    }

    public void InsertionSort() {
        int j = 0;
        int temp = 0;
        for(int i = 1; i < array.length; i++) {
            int value = array[i];
            j = i - 1;
            while(j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = value;
        }
    }

    public void MergeSort() {

    }

    public void QuickSort() {

    }

    public void display() {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        AllSortAlgorithms ss = new AllSortAlgorithms();
        // ss.BubbleSort();
        ss.InsertionSort();
        ss.display();
    }
}
