import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findMaxDistance {

    //Let us say we sort the array. Note that we cannot just blindly sort the array. We need to make sure that we also store the original index of the values when we are sorting the array.

    //Now iterate over every element in the sorted array as A[i]. Let us say index[i] stores the actual index of A[i].

    //Now we are looking for all values of A[j] which are bigger than A[i]. Since the array is sorted, all the elements to the right of A[i] will qualify for being A[j].
    //Since we want to maximize index[j] - index[i], and index[i] is fixed, we are essentially looking at max index[j] for all j > i.

    //This seems much easier. Can you think of a solution from this point?

    public int findMaxDist(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            for(int j = list.size() - 1 ; j > i; j--) {
                if(list.get(i) <= list.get(j)){
                    max = Math.max(max, (j - i));
                }
            }
        }
        return max;
    }

    public int maxDist(List<Integer> list) {
        int max = -1;
        int i,j;
        int[] rightMax = new int[list.size()];
        int[] leftMin = new int[list.size()];

        leftMin[0] = list.get(0);
        for(i = 1; i < list.size(); i++) {
            leftMin[i] = Math.min(list.get(i), leftMin[i - 1]);
        }
        rightMax[list.size() - 1] = list.get(list.size() - 1);
        for(j = list.get(list.size() - 2); j >= 0; j--) {
            rightMax[j] = Math.max(list.get(j), rightMax[j + 1]);
        }
        i = 0; j = 0;
        while(j < list.size() && i < list.size()) {
            if(leftMin[i] < rightMax[j]) {
                max = Math.max(max, (j-i));
                j = j + 1;
            }else {
                i = i + 1;
            }
        }
        return max;
    }

    int maxIndexDiff(List<Integer> arr) {
        int n = arr.size();
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];
        LMin[0] = arr.get(0);
        for (i = 1; i < n; ++i) {
            LMin[i] = Math.min(arr.get(i), LMin[i - 1]);
            System.out.println(LMin[i]);
        }


        RMax[n - 1] = arr.get(n - 1);
        for (j = n - 2; j >= 0; j--) {
            RMax[j] = Math.max(arr.get(j), RMax[j + 1]);
            System.out.println(RMax[j]);
        }

        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n)
        {
            if (LMin[i] <= RMax[j])
            {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            }
            else {
                i = i + 1;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,5,4,2);
        findMaxDistance fs = new findMaxDistance();
        System.out.println(fs.maxIndexDiff(list));
    }
}
