import java.util.LinkedList;

public class genericLinkList<T> {

    private LinkedList<T> list;

    public  void addNewNode(T value){
        if(list == null) {
            list.add(value);
        }else {
            while( != null)
        }
    }


}
