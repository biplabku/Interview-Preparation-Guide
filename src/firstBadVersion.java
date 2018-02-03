public class firstBadVersion {

    public static boolean isBadVersion(int version) {
        return true;
    }

    public static int findFirstBadVersion(int number) {
        int low = 1;
        int high = number;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(!isBadVersion(mid)) {
                low = mid - 1;
            }else {
                high = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {

    }
}
