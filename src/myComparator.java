import java.util.Comparator;

public class myComparator implements Comparator<Integer> {

    public int compare(Integer x, Integer y) {
        return y-x;
    }
}
