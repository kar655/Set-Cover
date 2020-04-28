package cover;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy extends Strategy {

    private static Greedy strategy = new Greedy();

    private Greedy() {
    }

    private int efficient(ArrayList<SetSum> setSums, Request request) {
        int num = 0;
        int id = -1;
        for (int i = 0; i < setSums.size(); i++) {
            if (setSums.get(i).numberOfNew(request) > num) {
                num = setSums.get(i).numberOfNew(request);
                id = i;
            }
        }

        return id;
    }

    public static Greedy give() {
        return strategy;
    }

    @Override
    public void solve(SetCollection setCollection, Request request) {
        ArrayList<Integer> output = new ArrayList<>();
        int id;

        while (!request.finished()) {
            id = efficient(setCollection.getSetSums(), request);
            if (id == -1)
                break;
            setCollection.getSetSums().get(id).solve(request);
            output.add(setCollection.getSetSums().get(id).getId());
        }

        if (request.finished()) {
            Collections.sort(output);
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i));
                if (i != output.size() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        } else {
            System.out.println("0");
        }

    }
}
