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
        int min = 0;
        int temp = 0;
        for(int i = 0; i < array.length; i++) {
            min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public void InsertionSort() {
        /*
        Worst Case Time Complexity : O(n2)
        Best Case Time Complexity : O(n2)
        Average Time Complexity : O(n2)
        Space Complexity : O(1)
        */

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
        int[] temp = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        mergeSort(array, temp, 0, array.length -1);

    }

    public void mergeSort(int[] array,int[] temp,  int startindex, int endindex) {
        if(startindex < endindex) {
            int middle = (startindex + endindex )/ 2;
            mergeSort(array,temp, startindex, middle);
            mergeSort(array,temp, middle + 1, endindex);
            domerge(array,temp, startindex, middle + 1, endindex);
        }
    }

    public void domerge(int[] array,int[] temp, int left, int right, int rightEnd) {

        int leftEnd = right - 1;
        int counter = left;

        while(left <= leftEnd && right <= rightEnd ) {
            if(array[left] <= array[right]) {
                temp[counter++] = array[left++];
            }else {
                temp[counter++] = array[right++];
            }
        }
        while(left <= leftEnd) {
            temp[counter++] = array[left++];
        }
        while(right <= rightEnd) {
            temp[counter++] = array[right++];
        }
        for(int  i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }

    public void QuickSort() {
        quicksort( 0, array.length -1);
    }

    public void quicksort( int left, int right) {
        if(left < right) {
            int partitionIndex = partition( left, right);
            quicksort(left, partitionIndex-1);
            quicksort(partitionIndex, right);
        }
    }

    public int partition(int left, int right) {
        int pivot = array[(left + right)/2];
        int i = left;
        int j = right;
        while(i <= j) {
            while(array[i] < pivot) {
                i++;
            }
            while(array[j] > pivot) {
                j--;
            }
            if(i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    public void display() {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        AllSortAlgorithms ss = new AllSortAlgorithms();
        // ss.BubbleSort();
        // ss.InsertionSort();
        // ss.SelectionSort();
        // ss.MergeSort();
        ss.QuickSort();
        ss.display();
    }
}
