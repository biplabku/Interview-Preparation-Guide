import java.util.ArrayList;

public class nonNegMaxSum {

    // A : [1, 2, 3, -7, 2, 3]
    // [1, 2, 5] [2, 3]
    public ArrayList<Integer> maxNonNegSubArray(ArrayList<Integer> list) {
        int curSum = 0;
        int curStartIndex = 0;
        int curLen = 0;
        int max = 0;
        int maxStartIndex = 0;
        int maxLen = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) < 0) {
                if((curSum > max) || (curSum == max) && (curLen > maxLen)) {
                    max = curSum;
                    maxStartIndex = curStartIndex;
                    maxLen = curLen -1;
                }
                curStartIndex = i + 1;
                curSum = 0;
                curLen = 0;
            }else {
                curSum += list.get(i);
                ++curLen;
            }
        }
        System.out.println(maxStartIndex + " " + maxLen + " " + max + " " + curSum);
        if((curSum > max) || (curSum == max) && (curLen > maxLen)) {
            max = curSum;
            maxStartIndex = curStartIndex;
            maxLen = curLen - 1;
        }
        System.out.println(maxStartIndex + " " + (maxLen + maxStartIndex));
        return new ArrayList<>(list.subList(maxStartIndex, maxLen));
    }


    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int index = 0;
        int sum = 0;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) < 0) {
                index = i;
                continue;
            }

        }
        for(int i = 0; i < index; i++) {
            sum += A.get(i);
        }
        int sum2 = 0;
        for(int i = index + 1; i < A.size(); i++) {
            sum2 += A.get(i);
        }

        if(sum > sum2) {
            return new ArrayList<>(A.subList(0, index ));
        }else if(sum == sum2) {
            return A.subList(0, index).size() > A.subList(index + 1, A.size()).size() ?
                    new ArrayList<>(A.subList(0, index)) : new ArrayList<>(A.subList(index + 1, A.size()));
        }else {
            return new ArrayList<>(A.subList(index + 1, A.size()));
        }
    }

    public static void main(String[] args) {
        nonNegMaxSum ms = new nonNegMaxSum();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(-7);
        list.add(2);
        list.add(9);
        // System.out.println(ms.maxset(list));
        System.out.println(ms.maxNonNegSubArray(list));
    }
}
