import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class mergeIntervals {

    public ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals, Interval newInterval) {
        // add the new interval
        int size = intervals.size();
        if(size == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        boolean inserted = false;
        for(int i = 0; i < size; i++) {
            Interval temp = intervals.get(i);
            if(temp.startTime > temp.startTime) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            }
        }
        // adding at the last if its not inserted
        if(!inserted) {
            intervals.add(newInterval);
        }
        return merge(intervals);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        Collections.sort(intervals, new myComp());
        for(int i = 1; i < intervals.size(); i++) {
            Interval  temp = intervals.get(i);
            int len = list.size() - 1;
            if(list.get(len).endTime >= temp.startTime ) {

                list.get(len).startTime = Math.min(list.get(len).startTime,temp.startTime);
                list.get(len).endTime = Math.max(list.get(len).endTime,temp.endTime);
            }else {
                list.add(temp);
            }
        }
        // System.out.println(list.size());
        return list;
    }


    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            // case of empty arrayList with no such meetings
            if(intervals.size() == 0) {
                intervals.add(newInterval);
                return intervals;
            }
            List<Interval> res = new ArrayList<>();
            boolean isAdded = false;
            for(int i = 0; i < intervals.size(); i++){
                if(intervals.get(i).endTime > newInterval.startTime) {
                    intervals.add(i, newInterval);
                    isAdded = true;
                    break;
                }
            }
            if(isAdded == false) {
                intervals.add(newInterval);
            }

            // by this time you have all the intervals
            // now we have to merge the timings based on the start time and end time
            res.add(intervals.get(0));
            for(int i = 1; i < intervals.size(); i++) {
                Interval temp = intervals.get(i);
                int len = res.size() - 1;
                Interval t = res.get(len);
                if(t.endTime >= temp.startTime) {
                    t.endTime = Math.max(temp.endTime, t.endTime);
                    t.startTime = Math.min(temp.startTime, t.startTime);
                }else {
                    res.add(temp);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        mergeIntervals ms = new mergeIntervals();
        Interval temp = new Interval(2,5);

    }
}
