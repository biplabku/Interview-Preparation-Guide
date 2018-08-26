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

    public ArrayList<Integer> getMaxArray(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        int startIndex = -1;
        int endIndex = -1;
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i - 1) > list.get(i)) {
                startIndex = i - 1;
                break;
            }
        }
        if(startIndex == -1) {
            res.add(-1);
            return res;
        }
        for(int i = list.size()-1; i > 0; i--) {
            if(list.get(i - 1) > list.get(i)) {
                endIndex = i -1;
            }
        }
        int min = list.get(startIndex);
        int max = list.get(startIndex);
        for(int i = startIndex + 1; i < endIndex; i++) {
            if(list.get(i) < min) {
                min = list.get(i);
            }else if(list.get(i) > max) {
                max = list.get(i);
            }
        }

        for(int i = 0; i < startIndex; i++) {
            if(list.get(i) > min) {
                startIndex = i;
                break;
            }
        }

        for(int i = list.size() - 1; i  > endIndex; i--) {
            if(list.get(i) < max) {
                endIndex = i;
                break;
            }
        }
        res.add(startIndex);
        res.add(endIndex);
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
        System.out.println(ms.getMaxArray(list));
    }
}
