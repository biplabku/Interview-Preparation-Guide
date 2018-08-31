import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mergeOverlappTime  {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        Collections.sort(intervals, new myComp());
        for(int i = 1; i < intervals.size(); i++) {
            Interval  temp = intervals.get(i);
            int len = list.size() - 1;
            if(list.get(len).endTime >= temp.startTime ) {
                // Interval t = new Interval(list.get(len).startTime, temp.endTime);
                list.get(len).startTime = Math.min(list.get(len).startTime,temp.startTime);
                list.get(len).endTime = Math.max(list.get(len).endTime,temp.endTime);
            }else {
                list.add(temp);
            }
        }
        // System.out.println(list.size());
        display(list);
        return list;
    }



    public void display(ArrayList<Interval> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print("[" +list.get(i).startTime + ","+list.get(i).endTime + "]");
        }
    }



    public static void main(String[] args) {
        ArrayList<Interval> thelist = new ArrayList<>();
        thelist.add(new Interval(1,10));
        thelist.add( new Interval(2,9));
        thelist.add(new Interval(3,8));
        thelist.add(new Interval(4,7));
        thelist.add(new Interval(5,6));
        thelist.add(new Interval(6,6));
        System.out.println(thelist.get(0).startTime + " " + thelist.get(0).endTime);
        mergeOverlappTime ms = new mergeOverlappTime();
        ms.merge(thelist);
    }
}
