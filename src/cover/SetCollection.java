package cover;

import java.util.ArrayList;

public class SetCollection {

    private static SetCollection universe = new SetCollection();

    private ArrayList<SetSum> setSums;

    private SetCollection() {
        setSums = new ArrayList<>();
    }

    public static SetCollection give() {
        return universe;
    }

    public void addSetSum(SetSum setSum) {
        setSums.add(setSum);
    }

    public ArrayList<SetSum> getSetSums() {
        return setSums;
    }
}
