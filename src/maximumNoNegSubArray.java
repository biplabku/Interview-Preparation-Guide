/*
public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> list) {
        long sum = 0;
        long max = 0;
        int maxLen = 0;
        int curLen = 0;
        int curStartIndex = 0;
        int curEndIndex = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) < 0) {
                if(sum > max || ((sum == max) && (curLen > maxLen))) {
                    max = sum;
                    maxLen = curLen;
                    // saving the endIndex and startIndex of the maximum array indices
                    curEndIndex = i;
                    curStartIndex = i - curLen;
                }
                // reinitialize the values to zero so that the loop can start again for a new 
                // sub array
                sum = 0;
                curLen = 0;
            }else {
                sum += list.get(i);
                ++curLen;
            }
        }
        if(sum > max || ((sum == max) && (curLen > maxLen))) {
            curEndIndex = list.size() ;
            curStartIndex = list.size() - curLen;
        }
        return new ArrayList<>(list.subList(curStartIndex, curEndIndex));
    }
}

*/