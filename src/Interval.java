import java.util.LinkedList;

public class Interval implements Comparable<Interval>{
    public int startTime;
    public int endTime;

    public Interval(int start, int end) {
        startTime = start;
        endTime = end;
    }


    @Override
    public int compareTo(Interval interval) {
        if(this.startTime < interval.startTime) {
            return -1;
        }else if(this.startTime == interval.startTime) {
            return 0;
        }
        return 1;
    }

}
