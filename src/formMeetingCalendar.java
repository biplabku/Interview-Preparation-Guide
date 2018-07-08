import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class formMeetingCalendar {

    public ArrayList<meeting> list;

    public formMeetingCalendar() {

    }

    // merge Meeting times
    public static ArrayList<meeting> mergeMeetingTimes(ArrayList<meeting> theList) {
        ArrayList<meeting> sortedList = new ArrayList<>();
        for(int i = 0; i < theList.size(); i++) {
            sortedList.add(theList.get(i));
        }

        Collections.sort(sortedList, new Comparator<meeting>() {
            @Override
            public int compare(meeting o1, meeting o2) {
                return o1.getStartTime() - o2.getStartTime();
            }
        });

        ArrayList<meeting> mergeMeetings = new ArrayList<>();
        mergeMeetings.add(sortedList.get(0));

        for(meeting currentMeeting : sortedList) {
            meeting lastMergedMeeting = mergeMeetings.get(mergeMeetings.size() - 1);

            if(currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));
            }else {
                mergeMeetings.add(currentMeeting);
            }
        }
        return mergeMeetings;
    }

    public static void main(String[] args) {
        ArrayList<meeting> thelist = new ArrayList<>();
        thelist.add(new meeting(0,1));
        thelist.add(new meeting(3,5));
        thelist.add(new meeting(4,8));
        thelist.add(new meeting(10,12));
        thelist.add(new meeting(9,10));
        System.out.println(mergeMeetingTimes(thelist));
    }
}

