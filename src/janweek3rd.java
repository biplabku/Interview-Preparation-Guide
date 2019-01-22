public class janweek3rd {


    // Input: S = "loveleetcode", C = 'e'
    // Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

    public int[] shortestToChar(String str, char ch) {
        int[] array = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            int res = getClosestValue(str, i, ch);
            array[i] = res;
        }
        display(array);
        return array;
    }

    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public int getClosestValue(String str, int index, char ch) {
        int leftIndex = index;
        int rightIndex = index;
        int left = 0;
        int right = 0;
        while(leftIndex >= 0) {
            if(str.charAt(leftIndex) == ch) {
                break;
            }
            leftIndex--;
            left++;
        }
        if(leftIndex < 0) {
            left = Integer.MAX_VALUE;
        }
        while(rightIndex < str.length()) {
            if(str.charAt(rightIndex) == ch) {
                break;
            }
            rightIndex++;
            right++;
        }
        if(rightIndex >= str.length()) {
            right = Integer.MAX_VALUE;
        }
        return Math.min(left, right);
    }


    public static void main(String[] args) {
        janweek3rd js = new janweek3rd();
        String str = "loveleetcode";
        js.shortestToChar(str, 'e');
    }
}
