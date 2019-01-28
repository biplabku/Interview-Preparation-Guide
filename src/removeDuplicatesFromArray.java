import java.util.*;

public class removeDuplicatesFromArray {

    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 0;
        for(int i = 1; i <= num; i++) {
            arr[i] = getOnesFromBinary(i);
        }
        display(arr);
        return arr;
    }

    public int getOnesFromBinary(int val) {
        int res = 0;
        while(val > 0) {
            if(val % 2 == 1) {
                res += 1;
            }
            val = val /2;
        }
        return res;
    }

    // reverse only the words in a string
    public String reverseWords(String str) {
        str = str.trim();
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i > 0; i--) {
            if(words[i].length() < 1) {
                continue;
            }else {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        sb.append(words[0]);
        return sb.toString();
    }



    public void removeDups(int[] array) {
        int index = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i - 1] != array[i]) {
                array[index] = array[i];
                index++;
            }else {
                continue;
            }
        }
        for(int i = 0; i < index; i++) {
            System.out.println(array[i]);
        }
    }
    // 3, 2, 2, 3     3
    public void removeElement(int[] array, int val) {
        int index = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == val) {
                continue;
            }else {
                array[index++] = array[i];
            }
        }
        display(array);
    }

    public void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public String getPattern(String str) {
        HashMap<Character, Integer> hmap = new HashMap();
        StringBuilder  sb =  new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, i);
            }

        }

        for(int  i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(hmap.get(ch));
        }
        return sb.toString();
    }


    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        pattern = getPattern(pattern);
        for(int  i= 0; i < words.length; i++) {
            if(pattern.equalsIgnoreCase(getPattern(words[i]))) {
                list.add(words[i]);
            }
        }
        return list;
    }

    public int stringToInteger(String str) {
        str = str.trim(); //  removing the trailing spaces
        int sign = 1;
        int j;
        int i = 0;
        for(j = 0 ; j < str.length(); j++) {
            if(str.charAt(j) == '-') {
                sign = -1;
                i = j;
                break;
            }
        }
        if(sign == -1) {
            i = i + 1;
        }
        if(0 == str.charAt(i) - 'a' || 0 == str.charAt(i) - 'A') {
            return -1;
        }
        int res = str.charAt(i) - '0';
        i = i + 1;
        for(; str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++) {
            if(0 == str.charAt(i) - 'a' || 0 == str.charAt(i) - 'A') {
                return sign * res;
            }
            if(sign == 1) {
                if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 7) {
                    return Integer.MAX_VALUE;
                }
            }else if(sign == -1) {
                if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 8) {
                    return Integer.MIN_VALUE;
                }
            }



            res = res * 10 + str.charAt(i) - '0';
        }
        return sign * res;
    }


    public void findProdArray(int[] array) {
        int prodSum = 1;
        for(int i = 0; i < array.length; i++) {
            prodSum *= array[i];
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = prodSum/ array[i];
        }
        display(array);
    }


    public void findProdArrayEff(int[] array) {
        int[] original = Arrays.copyOf(array, array.length);
        for(int i = 0; i < array.length; i++) {
            array[i] = getProd(original[i], original);
        }
        display(array);
    }

    public int getProd( int key, int[] array) {
        int prod = 1;
        for(int i = 0; i < array.length; i++) {
            if(key != array[i]) {
                prod *= array[i];
            }
        }
        return prod;
    }


    public boolean checkPossibility(int[] array){
        boolean seen = false;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < array.length; i++) {
            if(array[i] >= array[i - 1]) {
                max = Math.max(max, array[i]);
                continue;
            }else if(seen) {
               return false;
            }else{
                array[i] = max;
                seen = true;
            }
        }
        return true;
    }


    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer one = o1[0];
                Integer two = o2[0];
                return one.compareTo(two);
            }
        });
        int count = 0;
        System.out.println(points[0].length + " " + points.length);
        for(int i = 1; i < points.length; i++) {
            int ycur = points[i-1][1];
            int xnxt = points[i][0];
            int j = i;
            if(ycur >= xnxt) {
                while(ycur >= xnxt) {
                    count++;
                    j = i + 1;
                    xnxt = points[j][0];
                }
            }else {
                count++;
            }
            i = j - 1;
        }
        return count;
    }





    public static void main(String[] args) {
        removeDuplicatesFromArray rs = new removeDuplicatesFromArray();
        int[] array = {3,4,2,3};
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(rs.findMinArrowShots(points));
    }
}
