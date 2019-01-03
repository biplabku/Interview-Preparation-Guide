public class Interval implements Comparable<Interval>{
    public int startTime;
    public int endTime;

    public Interval(int start, int end) {
        startTime = start;
        endTime = end;
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
    
    @Override
    public int compareTo(Interval interval) {
        if(this.startTime < interval.startTime) {
            return -1;
        }else if(this.startTime == interval.startTime) {
            return 0;
        }
        return 1;
    }

}
