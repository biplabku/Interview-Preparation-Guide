import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class meetupWeek3 {


    public int maxStackHeight(int[] array1, int[] array2, int[] array3) {
        doCumulativeSum(array1);
        doCumulativeSum(array2);
        doCumulativeSum(array3);

        int index2 = array2.length - 1;
        int index3 = array3.length - 1;
        for(int i = array1.length - 1; i>= 0; i--) {
            int element = array1[i];
            while(index2 >= 0 && array2[index2] != element) {
                index2--;
            }
            while(index3 >= 0 && array3[index3] != element) {
                index3--;
            }
            if(index2 < 0 || index3 < 0 || (index2 < 0 && index3 < 0)) {
                index2 = array2.length - 1;
                index3 = array3.length - 1;
                continue;
            }
            if(element == array1[index2] && element == array3[index3]) {
                return element;
            }
        }
        return  -1;
    }

    public void doCumulativeSum(int[] array) {
        for(int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + array[i];
        }
    }


    public int sumRangeBST(mergeOverlappTime.BSTNode root, int left, int right) {
        if(root == null) {
            return 0;
        }
        if(root.val < left) {
            return sumRangeBST(root.rightchild, left, right);
        }
        if(root.val > right) {
            return sumRangeBST(root.leftchild, left, right);
        }
        return root.val + sumRangeBST(root.leftchild, left, right) + sumRangeBST(root.rightchild, left, right);
    }

    public static class BSTNode{
        public mergeOverlappTime.BSTNode leftchild;
        public mergeOverlappTime.BSTNode rightchild;
        public int val;

        public BSTNode(int data) {
            val = data;
            leftchild = null;
            rightchild = null;
        }
    }

    public boolean checkPalindrome(String str, int index) {
        if(isPaldinrome(str)) {
            return true;
        }
        for(int i = 1; i <= str.length(); i++) {
            String temp1 = str.substring(0, i -1);
            String temp2 = str.substring(i);
            String temp = temp1 + temp2;
            if(isPaldinrome(temp)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPaldinrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    public static class ringBuffer {
        public int size;
        public int[] array;
        int front = 0;
        int rear = 0;
        int cursize ;
        public ringBuffer(int val) {
            size = val;
            cursize = 0;
            array = new int[size];
        }

        public void init() {
            array = new int[size];
        }

        public boolean push(int val) {
            if(cursize >= size) {
                return false;
            }
            rear = (rear + 1) % size;
            array[rear] = val;
            cursize++;
            return true;
        }

        public int pop() {
            if(cursize > 0) {
                cursize--;
                front = (front  + 1) % size;
                return array[front];
            }else{
                return -1;
            }
        }


    }

    public List<List<Integer>> subsetOfSet(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            // save the current result in a temporary list variable
            for(List<Integer> list: result) {
                temp.add(new ArrayList<>(list));
            }
            // Add the new number to all the elements in the variable list
            for(List<Integer> list:temp) {
                list.add(array[i]);
            }
            // now add the new element from the array into the mix and finally add into the result
            ArrayList<Integer> single = new ArrayList<>();
            single.add(array[i]);
            temp.add(single);
            result.addAll(temp);
        }
        result.addAll(new ArrayList<>());
        return result;
    }

    public void quickSortAlgorithm(int[] array, int low, int high) {
        if(low < high) {
            int partition =  partition(array, low, high);
            quickSortAlgorithm(array, low, partition - 1);
            quickSortAlgorithm(array, partition + 1, high );
        }
    }

    public int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        for(int j = low; j <= high; j++) {
            if(array[j] < pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i = i + 1;
            }
        }
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }



    public static void main(String[] args) {
        int[] array1 = new int[] {1,1,3,1,0,-1,9};
        int[] array2 = new int[] {2,2,1,4};
        int[] array3 = new int[] {5,1,4};


        meetupWeek3 ms = new meetupWeek3();
        /*
        System.out.println(ms.maxStackHeight(array1, array2, array3));
        String str = "aaab";
        System.out.println(ms.checkPalindrome(str, 0));

        ringBuffer rs = new ringBuffer(3);
        System.out.println(rs.push(3));
        System.out.println(rs.push(2));
        System.out.println(rs.push(1));
        System.out.println(rs.push(5));
        System.out.println(rs.pop());
        System.out.println(rs.push(8));
        System.out.println(rs.pop());
        System.out.println(rs.pop());
        System.out.println(rs.pop());
        System.out.println(rs.pop());
        */
        ms.quickSortAlgorithm(array1, 0, array1.length - 1);
        for(int i =0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        // System.out.println(ms.subsetOfSet(new int[]{1,2,3}));
    }
}
