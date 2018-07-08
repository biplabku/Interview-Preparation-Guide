import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class formMeetingCalendar {

    public ArrayList<Meeting> list;

    public formMeetingCalendar() {

    }

    // merge Meeting times
    public static ArrayList<Meeting> mergeMeetingTimes(ArrayList<Meeting> theList) {
        ArrayList<Meeting> sortedList = new ArrayList<>();
        for(int i = 0; i < theList.size(); i++) {
            sortedList.add(theList.get(i));
        }

        Collections.sort(sortedList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getStartTime() - o2.getStartTime();
            }
        });

        ArrayList<Meeting> mergeMeetings = new ArrayList<>();
        mergeMeetings.add(sortedList.get(0));

        for(Meeting currentMeeting : sortedList) {
            Meeting lastMergedMeeting = mergeMeetings.get(mergeMeetings.size() - 1);

            if(currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));
            }else {
                mergeMeetings.add(currentMeeting);
            }
        }
        return mergeMeetings;
    }

    public static void main(String[] args) {
        ArrayList<Meeting> thelist = new ArrayList<>();
        thelist.add(new Meeting(0,1));
        thelist.add(new Meeting(3,5));
        thelist.add(new Meeting(4,8));
        thelist.add(new Meeting(10,12));
        thelist.add(new Meeting(9,10));
        System.out.println(mergeMeetingTimes(thelist));
    }
}

