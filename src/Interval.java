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

    public LinkNode add2Numbers(LinkNode l1, LinkNode l2) {
        LinkNode result = new LinkNode();
        int sum =0;
        int carry = 0;
        while(l1 != null && l2 != null) {
            sum = l1.data + l2.data + carry;
            if(sum >= 10) {
                sum = sum % 2;
                carry = sum / 2;
            }
            result.data = sum;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        
    }
}
