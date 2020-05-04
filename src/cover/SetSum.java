package cover;

import java.util.ArrayList;

// sum of basic Sets
public class SetSum {

    private int id;
    private ArrayList<Set> sets;

    public SetSum(int id) {
        this.id = id;
        this.sets = new ArrayList<>();
    }

    public void addSet(Set set) {

//        sets.add(set);
        if (set.getType() == 0 && sets.size() != 0) { // merges set single
            if (sets.get(0).getType() == 0) {
                sets.get(0).data.add(set.data.get(0));

            } else {
                Set temp = sets.get(0);
                sets.set(0, set);
                sets.add(temp);
            }
        } else {
            sets.add(set);
        }
    }

    public boolean contains(int num) {
        for (Set set : sets)
            if (set.contains(num))
                return true;

        return false;
    }

    public boolean hasNew(Request req) {
        for (int i = 0; i < req.getSize(); i++) {
            // numbers in Request are indexed from 0
            if (req.getData().get(i) == 0 && contains(i + 1))
                return true;
        }

        return false;
    }

    public int numberOfNew(Request req) {
        int output = 0;

        for (int i = 0; i < req.getData().size(); i++) {
            // numbers in Request are indexed from 0
            if (req.getData().get(i) == 0 && contains(i + 1))
                output++;
        }

        return output;
    }

    public void solve(Request req) {
        for (int i = 0; i < req.getData().size(); i++) {
            if (req.getData().get(i) == 0) {
                req.setIth(i, contains(i + 1) ? 1 : 0);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void incrId() {
        id++;
    }
}
