import java.util.ArrayList;

public class maxUnsortedArray {

    public ArrayList<Integer> getMaxUnsorted(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        int prev = 0;
        int next = 0;
        int isChange = 0;
        // check if there is only one change
        if(list.size() < 2) {
            res.add(-1);
            return res;
        }
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) < list.get(i - 1) ) {
                prev = i -1;
                next = i;
                isChange += 1;
            }
        }
        if(isChange > 1 || isChange == 0)  {
            res.add(-1);
            return res;
        }
        // now swap that number
        res.add(prev);
        res.add(next);
        return res;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(10);
        list.add(10);
        list.add(15);
        list.add(10);
        list.add(15);
        list.add(10);
        list.add(10);
        list.add(15);
        list.add(10);
        list.add(15);
        maxUnsortedArray ms = new maxUnsortedArray();
        System.out.println(ms.getMaxUnsorted(list));
    }
}
