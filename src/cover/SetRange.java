package cover;

import java.util.ArrayList;

public class SetRange extends Set {

    public SetRange(ArrayList<Integer> args) {
        this.type = 2;
        // a b c
        this.data = args;
    }

    @Override
    public boolean contains(int num) {
        return num >= data.get(0) && num <= data.get(2)
                && (num - data.get(0)) % data.get(1) == 0;
    }
}
