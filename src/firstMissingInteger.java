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

    public void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        firstMissingInteger ms= new firstMissingInteger();
        List<Integer> list = Arrays.asList(3,4,-1,1);
        System.out.println(ms.getFirstMissingInteger(list));
    }
}
