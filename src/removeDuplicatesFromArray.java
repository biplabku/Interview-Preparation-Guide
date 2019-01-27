import java.util.*;

public class removeDuplicatesFromArray {

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



    public static void main(String[] args) {
        removeDuplicatesFromArray rs = new removeDuplicatesFromArray();
        int[] array = {3,2,1};

        rs.findProdArrayEff(array);
    }
}
