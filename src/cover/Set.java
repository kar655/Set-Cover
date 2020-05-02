package cover;

import java.util.ArrayList;

public abstract class Set {

    // 0 - SetSingle; 1 - SetSeries; 2 - SetRange
    protected int type;
    protected ArrayList<Integer> data;

    // returns arraylist of Integers with 1 or 0.
    // 1 is placed on i+1-th index when set contains i
//    public abstract ArrayList<Integer> add(Request req);

    // returns amount of owned numbers less or equal to num
//    public abstract int numberOfNew(Request req);

    // checks if this set contains num
    public abstract boolean contains(int num);

    public int getType() {
        return type;
    }
}
