package cover;

import java.util.ArrayList;
import java.util.Collections;

public class Request {

    private ArrayList<Integer> data;
    private int strategy;

    public Request(int n, int strategy) {
        data = new ArrayList<>(Collections.nCopies(n, 0));
        this.strategy = strategy;
    }

    private Request(ArrayList<Integer> arr, int strategy) {
        data = arr;
        this.strategy = strategy;
    }

    public boolean finished() {
        for(int num : data)
            if (num == 0)
                return false;

        return true;
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public void setIth(int i, int num) {
        data.set(i, num);
    }

    public int getStrategy() {
        return strategy;
    }

    public int getSize() {
        return data.size();
    }

    public Request copy() {
        ArrayList<Integer> copied = new ArrayList<>(data);

        return new Request(copied, this.strategy);
    }
}
