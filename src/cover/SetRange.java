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
        return num >= data.get(0) && num <= data.get(2) && (num - data.get(0)) % data.get(1) == 0;
    }

//    public void add(Request req) {
//        for (int i = data[0]; i <= Math.min(req.size, data[2]); i += data[1])
//            req.data[i - 1]++;
//    }

//    public int newNumbers(Request req) {
//        int result = 0;
//
//        for (int i = data[0]; i <= Math.min(req.size, data[2]); i += data[1])
//            if (req.data[i - 1] == 0)
//                result++;
//
//        return result;
//    }
}
