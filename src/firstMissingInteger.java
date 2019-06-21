import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class firstMissingInteger{

    public List<Integer> pivotList(List<Integer> list, int pivot) {
        /*
        List<Integer> smaller = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if(val < pivot) {
                smaller.add(val);
            }else if(val == pivot) {
                middle.add(val);
            }else {
                larger.add(val);
            }
        }

         smaller.addAll(middle);
        smaller.addAll(larger);
        return smaller;
         */
        int index = 0;
        int last = list.size() - 1;
        for(int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if(val < pivot) {
                int temp = list.get(index);
                list.set(index, val);
                list.set(i, temp);
                index++;
            }else if(val > pivot && index < last-1) {
                int temp = list.get(last);
                list.set(last, val);
                list.set(i, temp);
                last--;
            }
        }
       return list;
    }



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

    Stack<Character> thestack = new Stack<>();
    public boolean isBalanced(String str, int index) {
        if(index == str.length() - 1) {
            if(thestack.isEmpty()) {
                return true;
            }
            return false;
        }

        if(str.charAt(index) == '(') {
            thestack.push('(');
        }else if(str.charAt(index) == ')') {
            if(thestack.isEmpty()) {
                return false;
            }
            thestack.pop();
        }else if(str.charAt(index) == '*') {
            if(!thestack.isEmpty()) {
                thestack.pop();
                boolean result1 = isBalanced(str, index + 1);
                thestack.push('(');
                boolean result2 = isBalanced(str, index + 1);
                return result1 || result2;
            }else if(thestack.isEmpty()) {
                
            }
        }
        return true;
    }
    class A {
        A other;
        void fun() {
            A a= new A();
            A b = new A();
            a.other = b;
            b.other = a;
        }
    }


    public static void main(String[] args) {



        firstMissingInteger ms= new firstMissingInteger();
        List<Integer> list = Arrays.asList(9,12,3,5,14,10,10);
        System.out.println(ms.pivotList(list, 10));
        ms.stack3insert(1);
        ms.stack3insert(2);
        ms.stack3insert(3);
        ms.stack3insert(4);
        ms.stack3insert(5);
        ms.stack3insert(6);

    }
}
