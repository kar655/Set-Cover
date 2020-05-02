package cover;

import java.util.ArrayList;

public class SetSingle extends Set {

    public SetSingle(ArrayList<Integer> args) {
        this.type = 0;
        this.data = args;
    }


    @Override
    public boolean contains(int num) {
        for (int n : data)
            if (n == num)
                return true;

        return false;
    }

    public void merge(Set set) {
        data.add(set.data.get(0));
    }

//    public int newNumbers(Request req) {
//        int result = 0;
//
//        for (int num : data)
//            if (num <= req.size && req.data[num - 1] == 0)
//                result++;
//
//        return result;
//    }
}
