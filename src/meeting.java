public class meeting {

    public int startTime;
    public int endTime;

    public meeting(int sTime, int eTime) {
        this.endTime = eTime;
        this.startTime = sTime;
    }

    public void setStartTime(int stime) {
        startTime = stime;
    }

    public void setEndTime(int etime) {
        endTime = etime;
    }


    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
