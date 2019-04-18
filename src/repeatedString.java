import java.util.*;

public class repeatedString {

    public static int repeatedStringMatch(String A, String B) {
        StringBuilder res = new StringBuilder(A);
        System.out.println(res.toString());
        int count = 1;
        System.out.println(res.indexOf(B));
        while(res.indexOf(B) < 0){ // continue until we get a match
            if(res.length() - A.length() > B.length()){
                return -1;
            }
            res.append(A);
            count ++;
        }
        return count;
    }

    HashMap<Character, List<String>> hmap = new HashMap<>();
    List<String> combinations = new ArrayList<>();


    public List<String> phoneNumberStrings(String str) {
        if(str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        if(str.length() == 1) {
            return hmap.get(str.charAt(0));
        }
        hmap.put('2', Arrays.asList("a","b","c"));
        hmap.put('3', Arrays.asList("d","e","f"));
        hmap.put('4', Arrays.asList("g","h","i"));
        hmap.put('5', Arrays.asList("j","k","l"));
        hmap.put('6', Arrays.asList("m","n","o"));
        hmap.put('7', Arrays.asList("p","q","r","s"));
        hmap.put('8', Arrays.asList("t","u","v"));
        hmap.put('9', Arrays.asList("w","x","y","z"));

        getStringCombinations(str, 0);
        return combinations;
    }

    public void getStringCombinations(String str, int index) {
        if(index > str.length() - 1) {
            return ;
        }
        if(index == 0) {
            List<String> st1 = hmap.get(str.charAt(index));
            List<String> st2 = hmap.get(str.charAt(index + 1));
            for(int i =0; i < st1.size(); i++) {
                for(int j = 0; j < st2.size(); j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(st1.get(i));
                    sb.append(st2.get(j));
                    combinations.add(sb.toString());
                }
            }
            getStringCombinations(str, index + 2);
        }else {
            List<String> list = new ArrayList<>(combinations);
            List<String> next = hmap.get(str.charAt(index));
            combinations.clear();
            for(int i = 0; i < list.size(); i++) {
                String com = list.get(i);
                for(int j = 0; j < next.size(); j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com);
                    sb.append(next.get(j));
                    combinations.add(sb.toString());
                }
            }
            getStringCombinations(str, index + 1);
        }
    }

    public int perfectSquares(int number) {
        if(number <= 3) {
            return number;
        }
        int res = number;
        for(int i = 1; i <= number; i++) {
            int val = i * i;
            if(val > number) {
                break;
            }else {
                res = Math.min(res, 1 + perfectSquares(number - val));
            }
        }
        return res;
    }

    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0|| nums == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] + 1 == nums[i + 1]) {
                continue;
            }else {
                int first = nums[index];
                int secon = nums[i];
                StringBuilder sb = new StringBuilder();
                if(first != secon) {
                    sb.append(first);
                    sb.append("->");
                    sb.append(secon);
                }else {
                    sb.append(first);
                }
                index = i + 1;
                result.add(sb.toString());
            }
        }
        int first = nums[index];
        int secon = nums[nums.length - 1];
        StringBuilder sb = new StringBuilder();
        if(first != secon) {
            sb.append(first);
            sb.append("->");
            sb.append(secon);
            result.add(sb.toString());
        }else {
            sb.append(first);
            result.add(sb.toString());
        }
        return result;
    }

    int count = 0;
    public int countSubStrings(String str) {
        if(str.length() == 0 || str == null) {
            return 0;
        }
        getSubstrings(str, 0);
        return count;
    }

    public void getSubstrings(String str, int index) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                int end = j + i + 1;
                if(end <= str.length()) {
                    String temp = str.substring(j, end);
                    if(checkPalindrome(temp)) {
                        count++;
                    }
                }
            }
        }
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }

    }




    public static void main(String[] args) {
        repeatedString rs = new repeatedString();


    }
}
