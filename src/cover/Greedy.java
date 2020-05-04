package cover;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy extends Strategy {

    private static Greedy strategy = new Greedy();

    private Greedy() {
    }

    public static Greedy give() {
        return strategy;
    }

    // return index of SetSum with highest number of new elements
    // or if no new element can be added returns -1
    private int efficient(ArrayList<SetSum> setSums, Request request) {
        int num = 0;
        int id = -1;
        int numOfNew;

        for (int i = 0; i < setSums.size(); i++) {
            numOfNew = setSums.get(i).numberOfNew(request);

            if (numOfNew > num) {
                num = numOfNew;
                id = i;
            }
        }

        return id;
    }

    // prints output from ArrayList of added SetSums' ids
    private void printOutput(ArrayList<Integer> output) {
        Collections.sort(output);   // keep lexicographic order

        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i));

            if (i != output.size() - 1)     // no last space
                System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public void solve(SetCollection setCollection, Request request) {
        ArrayList<Integer> output = new ArrayList<>();
        int id;

        while (!request.finished()) {
            id = efficient(setCollection.getSetSums(), request);
            if (id == -1)   // can't get more elements
                break;

            setCollection.getSetSums().get(id).solve(request);
            output.add(setCollection.getSetSums().get(id).getId());
        }

        if (request.finished())
            printOutput(output);
        else
            System.out.println("0");
    }
}
