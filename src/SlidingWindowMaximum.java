import java.util.*;

public class SlidingWindowMaximum {

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        // time complexity -
        // O(N) * O(K)
        // O(N)
        for(int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result.add(max);
        }
        return result;
    }

    // O(N)*log(k);
    // O(N)
    public static List<Integer> maxSlidingFast(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = k;
        while(index1 < index2 && index2 < nums.length) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
                public int compare(Integer a1, Integer a2){
                    return a2 - a1;
                }
            });
            for(int i= index1; i < i + k; i++){
                queue.add(nums[i]);
            }
            result.add(queue.poll());
        }
        return result;
    }

    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.
    public static int lengthOfLongestSubstring(String str) {
        if(str.length() == 0 || str == null) {
            return 0;
        }
        int max = 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, i);
                queue.add(i);
                max = Math.max(max, i - queue.peek() + 1);
            }else {
                queue.poll();
                queue.add(i);
            }
        }
        return max;
    }










    // 1, 2,3,4,5,6,7,8
    // 5, 6, 7, 8
    // 7, 8
    // 4,5,6,7,0,1,2 == 0
    public static int searchInSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (right + left)/2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // 1, 2, 3, 4, 5, 6, 7
    public static int GetRunningMedian(int[] nums) {
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a1, Integer a2) {
                return a2 - a1;
            }
        });
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i =0; i < nums.length; i++) {
            int value = nums[i];
            min.add(value);
            if(max.size() + 1 < min.size()) {
                max.add(min.poll());
            }
        }

        return 1;
    }




    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
