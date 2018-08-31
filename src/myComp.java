import java.util.Comparator;


public class myComp implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        int temp = o1.startTime - o2.startTime;
        return temp;
    }
}
