import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class DailyCodingProblem {

    public int numberOfArithematicSlices(int[] array) {
        int res = 0;
        for(int i = 0; i < array.length - 2; i++) {
            int diff = array[i + 1] - array[i];
            for(int j = i + 2; j < array.length - 2; j++) {
                if(array[j] - array[j - 1] == diff) {
                    res++;
                }else {
                    break;
                }

            }
        }
        return res;
    }



    public boolean problem1(int[] array, int target) {
        HashSet<Integer> hset  = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            int diff = target - array[i];
            if(!hset.contains(diff)) {
                hset.add(array[i]);
            }else {
                return true;
            }
        }
        return false;
    }


    public boolean problem1Method2(int[] array, int k) {
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            int target = k - array[i];
            int j = binarySearch(array, target, 0, array.length, i);
            if(j != -1) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] array, int target, int start, int end, int index) {
        while(start < end) {
            int mid = (start + end) / 2;
            if(array[mid] == target && mid != index) {
                return mid;
            }else if(array[mid] > target) {
                start = mid + 1;
                binarySearch(array, target, start, end, index);
            }else if(array[mid] < target) {
                end = mid - 1;
                binarySearch(array, target, start, end, index);
            }
        }
        return -1;
    }

    int[] newArray;
    // this is still O(N2) implementation
    public void multiplyEach(int[] array) {
        newArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            doMultiply(array, i - 1, i + 1, i);
        }
        for(int i = 0; i < array.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    public void doMultiply(int[] array, int left, int right, int index) {
        int leftMul = 1;
        int rightMul = 1;
        while(left >= 0) {
            leftMul = leftMul * array[left];
            left--;
        }

        while(right < array.length) {
            rightMul = rightMul * array[right];
            right++;
        }
        newArray[index] = leftMul * rightMul;
    }

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int temp = 1;
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            if(i == 0) {
                result[i] = 1;
            }else {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }

        for(int i = size - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp = temp * nums[i];
        }
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }

    public int maxProductSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 1;
            for(int j = i; j < nums.length; j++) {
                sum = sum * nums[j];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxProductMethod2(int[] nums) {
        int maxProduct2 = nums[0] * nums[1];
        int maxProduct3 = maxProduct2 * nums[2];
        int res = 0;
        for(int i = 2; i < nums.length; i++) {
            int prod2 = nums[i - 1] * nums[i - 2];
            int prod3 = prod2 * nums[i];
            maxProduct2 = Math.max(maxProduct2, prod2);
            maxProduct3 = Math.max(maxProduct3, prod3);
            res = Math.max(maxProduct2, maxProduct3);
        }
        return res;
    }


    public boolean nQueenProblem(int number) {
        int[][] board = new int[number][number];
        for(int i = 0; i < number; i++) {
            for(int j = 0; j < number; j++) {
                board[i][j] = 0;
            }
        }

        if(solveNQueens(board, 0) == false) {
            return false;
        }
        return true;
    }

    public boolean solveNQueens(int[][] board, int col ) {
        if(col >= board.length) {
            return true;
        }

        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = 1;
                if(solveNQueens(board, col + 1) == true) {
                    return true;
                }
                board[i][col] = 0; //  this is the most important step of backtracking
            }
        }
        return false;
    }

    public boolean isSafe(int[][] board, int col, int row) {
        int i;
        int j;
        for(i = 0; i < col; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return  false;
            }
        }

        for(i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }



    public void generateRandNumbers(int k) {
        Random rand = new Random();
        int[] array = new int[52];
        for(int i = 0; i < 52; i++) {
            array[i] = i;
        }
        // shuffle the cards based on the random function generator
        for(int i = 0; i < array.length; i++) {
            int random = i + rand.nextInt(52 - i);
            int temp = array[random];
            array[random] = array[i];
            array[i] = temp;
        }
    }


    public static void main(String[] args) {
        DailyCodingProblem ds = new DailyCodingProblem();
        int[] array = {2,3,1,4};
        System.out.println(ds.maxProductMethod2(array));
    }
}
