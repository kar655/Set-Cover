package cover;

import java.util.ArrayList;

public class SetSingle extends Set {

    public SetSingle(ArrayList<Integer> data) {
        super(data);
    }

    @Override
    public boolean contains(int num) {
        for (int n : data)
            if (n == num)
                return true;

        return false;
    }
}
