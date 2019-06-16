import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class firstMissingInteger {



    public int getFirstMissingInteger(List<Integer> list) {
        int result = list.size()+1, itr = 0;
        while(itr < list.size()){
            if(list.get(itr) <= 0 || list.get(itr) > list.size()
                    || list.get(itr) == itr + 1){
                itr++;
            } else if(list.get(itr) != list.get(list.get(itr)-1)){
                swap(list, list.get(itr)-1, itr);
            } else {
                itr++;
            }
        }
        for(itr=0; itr < list.get(itr); itr++){
            if(itr+1 != list.get(itr)){
                return itr+1;
            }
        }
        return result;
    }

    List<Integer> stackusinglist = new ArrayList<>();

    int totLength = 0;
    int size = 2;
    int start1 = 0;
    int start2 = size;
    int start3 = 2 * size;
    int end1 = size;
    int end2 = 2 * size;
    int end3 = 3 * size;
    public void stack3insert( int val) {
        if(start1 != size) {
            push(val);
            start1++;
            totLength++;
        }else if(start2 != end2) {
            push(val);
            start2++;
            totLength++;
        }else if(start3 != end3) {
            push(val);
            start3++;
            totLength++;
        }else if(start1 == end1 || start2 == end2 || start3 == end3) {
            System.out.println("Size full");
        }
    }

    public void push(int val) {
        stackusinglist.add(val);
    }

    public int stack3remove() {
        if(end1 != 0) {
            int val = stackusinglist.get(end1-1);
            end1--;
            return val;
        }
        if(end2 != size) {
            int val = stackusinglist.get(end2-1);
            end2--;
            return val;
        }
        if(end3 != 2*size) {
            int val = stackusinglist.get(end3-1);
            end3--;
            return val;
        }
        if(end1 < 0 || end2 < size || end3 < 2*size) {
            System.out.println("Stack empty");
        }
        return -1;
    }


    public void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        firstMissingInteger ms= new firstMissingInteger();
        List<Integer> list = Arrays.asList(3,4,-1,1);
        ms.stack3insert(1);
        ms.stack3insert(2);
        ms.stack3insert(3);
        ms.stack3insert(4);
        ms.stack3insert(5);
        ms.stack3insert(6);
        for(int i = 0; i < 8; i++) {
            System.out.println(ms.stack3remove());
        }
    }
}
