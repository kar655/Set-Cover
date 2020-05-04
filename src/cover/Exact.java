package cover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Exact extends Strategy {

    private static Exact strategy = new Exact();

    private Exact() {
    }

    public static Exact give() {
        return strategy;
    }

    // return position of last 1 is arr
    private int findLast(ArrayList<Integer> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) == 1)
                return i;
        }
        return -1;
    }

    // prints output from arr and setCollection's ids
    private void printOutput(ArrayList<Integer> arr, SetCollection setCollection) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < arr.size(); i++)
            if (arr.get(i) == 1)
                output.append(setCollection.getSetSums().get(i).getId()).append(" ");

        output.setLength(output.length() - 1); // remove last space
        System.out.println(output);
    }

    // adds to both queues one of SetSum in lexicographic order
    // true if finished else false
    private boolean initialize(SetCollection setCollection,
                               Request request, int length,
                               Queue<ArrayList<Integer>> q,
                               Queue<Request> requestQueue) {

        ArrayList<Integer> added;
        Request temporary;


        for (int i = 0; i < length; i++) {

            added = new ArrayList<>(Collections.nCopies(length, 0));
            added.set(i, 1);

            temporary = request.copy();
            if (!setCollection.getSetSums().get(i).hasNew(temporary))
                continue;   // i-th SetSum doesn't have any necessary elements

            setCollection.getSetSums().get(i).solve(temporary);

            if (temporary.finished()) {     // finished by one SetSum
                System.out.println(setCollection.getSetSums().get(i).getId());
                return true;
            }

            requestQueue.add(temporary);
            q.add(added);
        }

        return false;
    }

    // loop over all states of adding SetSums
    // print result and return true if can be done else false
    private boolean bfs(SetCollection setCollection, int length,
                        Queue<ArrayList<Integer>> q,
                        Queue<Request> requestQueue) {

        ArrayList<Integer> added;
        Request fromQueue;
        Request temp;
        int last;

        while (!q.isEmpty()) {

            fromQueue = requestQueue.peek();
            last = findLast(q.peek());

            for (int i = last + 1; i < length; i++) {

                if (q.peek().get(i) == -1) // known useless
                    continue;

                if (!setCollection.getSetSums().get(i).hasNew(fromQueue)) { // useless
                    q.peek().set(i, -1);
                    continue;
                }

                if (q.peek().get(i) == 0) {
                    added = new ArrayList<>(q.peek());
                    temp = fromQueue.copy();

                    setCollection.getSetSums().get(i).solve(temp);
                    added.set(i, 1);

                    if (temp.finished()) {
                        printOutput(added, setCollection);
                        return true;
                    }

                    q.add(added);
                    requestQueue.add(temp);
                }
            }

            q.remove();
            requestQueue.remove();
        }

        return false;
    }

    @Override
    public void solve(SetCollection setCollection, Request request) {

        int length = setCollection.getSetSums().size();
        // -1 - doesn't add anything, 0 - not added, 1 - added
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        Queue<Request> requestQueue = new LinkedList<>();


        if (initialize(setCollection, request, length, q, requestQueue))
            return; // already finished by one SetSum

        if (!bfs(setCollection, length, q, requestQueue))
            System.out.println("0"); // can't be done
    }
}
