package cover;

import java.util.ArrayList;

public abstract class Set {

    // 0 - SetSingle; 1 - SetSeries; 2 - SetRange
    protected int type;
    protected ArrayList<Integer> data;

    // checks if this set contains num
    public abstract boolean contains(int num);

    public int getType() {
        return type;
    }
}
