import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class compareVersion {


    public int compareVersion(final String v1, final String v2) {
        return solve(Arrays.stream(v1.split("\\.")).map(s -> new BigInteger(s))
                .collect(Collectors.toList()), Arrays.stream(v2.split("\\.")).map(s -> new BigInteger(s))
                .collect(Collectors.toList()), 0);
    }

    private int solve(final List<BigInteger> l1, final List<BigInteger> l2, final int i) {
        if (i >= l1.size() && i >= l2.size())
            return 0;
        if (i >= l2.size())
            return l1.get(i).compareTo(BigInteger.valueOf(0));
        if (i >= l1.size())
            return -l2.get(i).compareTo(BigInteger.valueOf(0));
        final int res = l1.get(i).compareTo(l2.get(i));
        if (res == 0)
            return solve(l1, l2, i + 1);
        return res;
    }

    public static void main(String[] args) {
        compareVersion cm = new compareVersion();
        String str1 = "13.0.8";
        String str2 = "13.0";
        System.out.println(cm.compareVersion(str1, str2));
    }
}
