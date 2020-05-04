package cover;

import java.util.ArrayList;

public abstract class Set {

    protected ArrayList<Integer> data;

    public Set(ArrayList<Integer> data) {
        this.data = data;
    }

    // checks if this set contains num
    public abstract boolean contains(int num);

}
