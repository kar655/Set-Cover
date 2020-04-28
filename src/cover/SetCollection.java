package cover;

import java.util.ArrayList;

public class SetCollection {

    private static SetCollection universe = new SetCollection();

    private ArrayList<SetSum> setSums;

    public static SetCollection give() {
        return universe;
    }

    private SetCollection() {
        setSums = new ArrayList<>();
    }

    public void addSetSum(SetSum setSum) {
        setSums.add(setSum);
    }

    public ArrayList<SetSum> getSetSums() {
        return setSums;
    }

    public boolean contains(int num) {
        for (SetSum setSum : setSums)
            if (setSum.contains(num))
                return true;

        return false;
    }
}
