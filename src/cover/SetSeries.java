package cover;

import java.util.ArrayList;

public class SetSeries extends Set {

    public SetSeries(ArrayList<Integer> args) {
        this.type = 1;
        this.data = args;
        // a b
    }

    @Override
    public boolean contains(int num) {
        return num >= data.get(0) && (num - data.get(0)) % data.get(1) == 0;
    }

//    public void add(Request req) {
//        for (int i = data[0]; i <= req.size; i += data[1])
//            req.data[i - 1]++;
//    }
//
//    public int newNumbers(Request req) {
//        int result = 0;
//
//        for (int i = data[0]; i <= req.size; i += data[1])
//            if (req.data[i - 1] == 0)
//                result++;
//
//        return result;
//    }
}
