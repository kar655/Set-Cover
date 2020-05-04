package cover;

import java.util.ArrayList;

public class SetSeries extends Set {

    public SetSeries(ArrayList<Integer> args) {
        this.type = 1;
        // a b
        this.data = args;
    }

    @Override
    public boolean contains(int num) {
        return num >= data.get(0) && (num - data.get(0)) % data.get(1) == 0;
    }
}
