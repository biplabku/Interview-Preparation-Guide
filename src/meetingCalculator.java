import java.util.ArrayList;

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
                    list.add(new meeting(mstart.getStartTime(), mend.getEndTime()));
                }else {
                    list.add(mstart);
                    list.add(mend);
                }
            }
        }
    }

    public static void main(String[] args) {
        meeting m1 = new meeting(1,2);
        meeting m2 = new meeting(3,4);
        meeting m3 = new meeting(4,5);
        meeting m4 = new meeting(8,9);

        meeting[] array = new meeting[] {m1, m2,m3, m4};

    }
}
