import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class nthMinElement {


    public int minElement(int[] array) {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

    public int secondMinElement(int[] array) {
        int min = array[0];
        int secondMin = array[1];
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                secondMin = min;
                min = array[i];
            }else if(array[i] < secondMin) {
                secondMin = array[i];
            }
        }
        return secondMin;
    }

    public int nthMinElement(int[] array, int n) {
        int start = 0;
        int end = array.length - 2;
        int[] newArray = new int[array.length ];
        int index = 0;
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[index]) {
                newArray[start] = array[i];
                start++;
            }else {
                newArray[end] = array[i];
                end--;
            }
        }
        System.out.println(Arrays.toString(newArray));
        if(n > start) {
            return nthMinElement(Arrays.copyOfRange(newArray, start + 1 , newArray.length),
                    n -  start);
        }else if(n < start) {
            return nthMinElement(Arrays.copyOfRange(newArray, 0, start), n);
        }else{
            return array[start];
        }
    }

    public int nextTryMinElement(int[] array, int k) {
        int pivot = array[0];
        int[] newArray = new int[array.length];
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        for(int i = 0; i < array.length; i++) {
            if(array[i] <= pivot) {
                newArray[leftIndex] = array[i];
                leftIndex++;
            }else {
                newArray[rightIndex] = array[i];
                rightIndex--;
            }
        }

        if(k < leftIndex) {
            return nextTryMinElement(Arrays.copyOfRange(newArray, 0, leftIndex), k);
        }else if(k > leftIndex) {
            return nextTryMinElement(Arrays.copyOfRange(newArray, leftIndex + 1, newArray.length), k - leftIndex);
        }
        return pivot;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isomorphicStrings(String str, String ptr) {
        if(str.length() != ptr.length()) {
            return false;
        }
        HashMap<Character, Integer> hmap1 = new HashMap<>();
        HashMap<Character, Integer> hmap2 = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch2 = ptr.charAt(i);
            char ch1 = str.charAt(i);
            if(!hmap1.containsKey(ch1)) {
                hmap1.put(ch1, i);
            }
            if(!hmap2.containsKey(ch2)) {
                hmap2.put(ch2, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            sb.append(hmap1.get(str.charAt(i)));
            sb2.append(hmap2.get(ptr.charAt(i)));
        }

        return sb.toString().equalsIgnoreCase(sb2.toString());
    }


    public boolean isomorphFast(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Character> hmap = new HashMap<>();
        for(int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if(!hmap.containsKey(ch1)) { //  if it does not contain the first value
                if(hmap.containsValue(ch2)) {
                    return false;
                }else{
                    hmap.put(ch1, ch2);
                }
            }else {
                if(hmap.get(ch1) == ch2) {
                    continue;
                }else {
                    return false;
                }
            }
        }
        return  true;
    }

    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        nthMinElement ms = new nthMinElement();
        int[] array = {5,6,3,15,11};
        // System.out.println(ms.nextTryMinElement(array, 3));
        String str = "abba";
        String ptr = "abab";
        System.out.println(ms.isomorphFast(str, ptr));
    }
}
