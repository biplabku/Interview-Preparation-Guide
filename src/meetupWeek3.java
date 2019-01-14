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
        // takes O(N) runtime
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {1,1,3,1};
        int[] array2 = new int[] {2,2,1,4};
        int[] array3 = new int[] {5,1,4};

        meetupWeek3 ms = new meetupWeek3();
        System.out.println(ms.maxStackHeight(array1, array2, array3));
        String str = "aaab";
        System.out.println(ms.checkPalindrome(str, 0));
    }
}
