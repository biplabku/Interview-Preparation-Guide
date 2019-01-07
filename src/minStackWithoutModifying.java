import java.util.ArrayList;
import java.util.Arrays;

public class minStackWithoutModifying {

    int curSize = 0;
    int size = 4;
    int[] array ;
    int min ;
    public minStackWithoutModifying(int val) {
        array = new int[size];
        min = Integer.MAX_VALUE;
        curSize = 0;
    }

    public boolean isEmpty() {
        if(curSize == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(curSize == size - 1) {
            return true;
        }
        return false;
    }

    public void push(int x) {
        if(!isEmpty() || !isFull()) {        // if its not empty
            array[curSize] = x;
            if(min > x) {
                min = Math.min(x, min);
            }
            curSize++;
        }else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if(!isEmpty()) {
            int val = array[curSize - 1];
            curSize--;
            updateMin();
            return val;
        }
        return-1;
    }

    public void updateMin() {
        min = array[curSize - 1];
        for(int i =0; i < curSize; i++) {
            min = Math.min(min, array[i]);
        }
    }

    public int getMin() {
        return min;
    }

    public int peek() {
        if(!isEmpty()) {
            return array[curSize];
        }
        return -1;
    }

    public void display() {
        for(int i =0; i < curSize; i++) {
            System.out.println(array[i]);
        }
    }

    public ArrayList<ArrayList<Integer>> subsetsofSet(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        Arrays.sort(input.toArray());
        for(int i = 0; i < input.size(); i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            // copying the all the sublist which are already there
            for(ArrayList<Integer> list : finalResult) {
                temp.add(new ArrayList<>(list));
            }

            // adding the element to all the sublist
            for(ArrayList<Integer> list : temp) {
                list.add(input.get(i));
            }
            ArrayList<Integer> single = new ArrayList<>();
            single.add(input.get(i));
            temp.add(single);
            finalResult.addAll(temp);
        }
        finalResult.add(new ArrayList<>());
        return finalResult;
    }


    public ArrayList<Integer> incDecNumber(String str) {
        int[] array = new int[str.length() + 1];
        for(int i = 0; i <= str.length(); i++) {
            array[i] = i;
        }
        int leftIndex = -1;
        int rightIndex = str.length()+1;
        ArrayList<Integer> list = new ArrayList<>();
        int counter =0;
        while(counter < str.length()) {
            if(str.charAt(counter) == 'D') {
                list.add(array[--rightIndex]);
            }else if(str.charAt(counter) == 'I') {
                list.add(array[++leftIndex]);
            }
            counter++;
        }
        list.add(rightIndex - 1);
        System.out.println(leftIndex + " <--val --> " +rightIndex);
        return list;
    }


    public static void main(String[] args) {
        minStackWithoutModifying ms = new minStackWithoutModifying(4);
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(0);
        //ms.display();
        // ms.pop();
        // System.out.println(ms.getMin());
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        //System.out.println(ms.subsetsofSet(temp));
        System.out.println(ms.incDecNumber("DDI"));
    }
}
