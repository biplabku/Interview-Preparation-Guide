import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mergeOverlappTime  {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        Collections.sort(intervals, new myComp());
        for(int i = 1; i < intervals.size(); i++) {
            Interval  temp = intervals.get(i);
            int len = list.size() - 1;
            if(list.get(len).endTime >= temp.startTime ) {
                // Interval t = new Interval(list.get(len).startTime, temp.endTime);
                list.get(len).startTime = Math.min(list.get(len).startTime,temp.startTime);
                list.get(len).endTime = Math.max(list.get(len).endTime,temp.endTime);
            }else {
                list.add(temp);
            }
        }
        // System.out.println(list.size());
        display(list);
        return list;
    }



    public void display(ArrayList<Interval> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print("[" +list.get(i).startTime + ","+list.get(i).endTime + "]");
        }
    }


    public int sumRangeBST(BSTNode root, int left, int right) {
        if(root == null) {
            return 0;
        }
        if(root.val < left) {
            return sumRangeBST(root.rightchild, left, right);
        }
        if(root.val > right) {
            return sumRangeBST(root.leftchild, left, right);
        }
        return root.val + sumRangeBST(root.leftchild, left, right) + sumRangeBST(root.rightchild, left, right);
    }

    public static class BSTNode{
        public BSTNode leftchild;
        public BSTNode rightchild;
        public int val;

        public BSTNode(int data) {
            val = data;
            leftchild = null;
            rightchild = null;
        }


    }












    // Comparable tutorials
    // Comparable
    // as the name suggests is an interface defining a strategy of comparing an object with other objects of the
    // same type. This is called the class's natural ordering.
    // We have a set of tables and we need to sort them by weight. If so, are we sorting them from lightiest
    // to heaviest or heaviest to lightest? When we are sorting them, we need to repeatedly compare 2 apples until all the apples are in
    // correct order. Comparable cant sort the objects on its own, but the interface defines a method int compareTo(T)

    // How compareTo() works ?
    // compareTo works by returning an int value that is either positive, negative or zero.
    // It compares the object by making the call to the object that is the argument.  A negative number means that object making the call is "less"
    // than the argument.

    // Flexibility of compareTo
    // if we called the compareTo nethod, we could sort our apples by size, which is great, but what if we want to sort apples by color? Or weight?
    // Here we could do that. But the objective needs to be define how it needs to be sorted.
    // example - Like which character of the apple needs to be compared.
    // also what does "less than", "equal to" and "greater than" mean in that context?


    public static void main(String[] args) {
        ArrayList<Interval> thelist = new ArrayList<>();
        thelist.add(new Interval(1,10));
        thelist.add( new Interval(2,9));
        thelist.add(new Interval(3,8));
        thelist.add(new Interval(4,7));
        thelist.add(new Interval(5,6));
        thelist.add(new Interval(6,6));
        // System.out.println(thelist.get(0).startTime + " " + thelist.get(0).endTime);
        mergeOverlappTime ms = new mergeOverlappTime();
        // ms.merge(thelist);
        BSTNode bs = new BSTNode(9);
        bs.rightchild = new BSTNode(12);
        bs.rightchild.leftchild = new BSTNode(10);
        bs.leftchild = new BSTNode(6);
        bs.leftchild.rightchild = new BSTNode(8);
        bs.leftchild.leftchild = new BSTNode(1);

        System.out.println(ms.sumRangeBST(bs, 6, 12));
    }
}
