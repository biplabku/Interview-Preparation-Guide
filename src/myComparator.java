import java.util.Comparator;

public abstract class myComparator implements Comparator<Object> {

    public boolean compare(Integer x, Integer y) {
        if(y == x) {
            return true;
        }
        return false;
    }

    public boolean compare(String x, String y) {
        return x.equals(y);
    }

    public boolean compare(int[] a, int[] b) {
        if(a.length != b.length) {
            return false;
        }
        return a.toString().equals(b.toString());
    }

}

