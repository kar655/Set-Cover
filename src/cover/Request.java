package cover;

import java.util.ArrayList;
import java.util.Collections;

public class Request {

    private int added;
    private ArrayList<Integer> data;
    private int strategy;

    public Request(int n, int strategy) {
        data = new ArrayList<>(Collections.nCopies(n, 0));
        this.strategy = strategy;
        this.added = 0;
    }

    private Request(ArrayList<Integer> arr, int strategy, int added) {
        data = arr;
        this.strategy = strategy;
        this.added = added;
    }

    public boolean finished() {
        return added == data.size();
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public void setIth(int i, int num) {
        data.set(i, num);
        if (num == 1)
            added++;
    }

    public int getStrategy() {
        return strategy;
    }

    public int getSize() {
        return data.size();
    }

    public Request copy() {
        ArrayList<Integer> copied = new ArrayList<>(data);

        return new Request(copied, this.strategy, this.added);
    }
}
