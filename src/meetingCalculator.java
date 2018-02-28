import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class meetingCalculator {


    // the only way to merge the timings of the calendar is to combine the values if the end
    // time of the first interview is more the start time of the second interview


    public static void manageCalendar(meeting[] array, meeting m1) {
        ArrayList<meeting> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i].getEndTime() >= array[j].getStartTime()) {
                    meeting temp = new meeting(array[i].getStartTime(), array[j].getEndTime());
                    list.add(temp);
                }else if(array[i].getStartTime() > array[j].startTime){

                }else {

                }
            }
        }
    }



    public static void manageCalendarMethod2(meeting[] array) {
        ArrayList<meeting> list = new ArrayList<>();
        for(int i =0 ; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                meeting mstart = array[i].startTime < array[j].startTime ? array[i] : array[j];
                meeting mend = array[i].startTime > array[j].startTime ? array[j] : array[i];
                if(mstart.endTime >= mend.startTime) {
                    list.add(new meeting(mstart.getStartTime(), Math.max(mstart.getEndTime(), mend.getEndTime())));
                }else {
                    list.add(mstart);
                    list.add(mend);
                }
            }
        }
    }


    public static void mergeCalendar(ArrayList<meeting> list) {
        ArrayList<meeting> sortedTimings = new ArrayList<>();
        // copying the original
        for(meeting m : list) {
            sortedTimings.add(new meeting(m.getStartTime(), m.getEndTime()));
        }
        // sort the meeting times based on the start times
        Collections.sort(sortedTimings, new Comparator<meeting>(){
            @Override
            public int compare(meeting o1, meeting o2) {
                return o1.getStartTime() - o2.getStartTime();
            }
        });

        for(int i = 0; i < list.size(); i++) {
            
        }

    }


    public static void main(String[] args) {
        meeting m1 = new meeting(1,2);
        meeting m2 = new meeting(3,4);
        meeting m3 = new meeting(4,5);
        meeting m4 = new meeting(8,9);

        meeting[] array = new meeting[] {m1, m2,m3, m4};
        ArrayList<meeting> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);


    }
}
