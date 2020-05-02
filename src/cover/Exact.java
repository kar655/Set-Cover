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

    private void bfs() {

    }

    private int findLast(ArrayList<Boolean> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i))
                return i;
        }
        return -1;
    }

    private void printOutput(ArrayList<Boolean> arr, SetCollection setCollection) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i)) {
                output.append(setCollection.getSetSums().get(i).getId()).append(" ");
            }
        }

        output = new StringBuilder(output.substring(0, output.length() - 1)); // remove last space
        System.out.println(output);
    }

    @Override
    public void solve(SetCollection setCollection, Request request) {
//        ArrayList<ArrayList<Integer>> visited = new ArrayList<>();
        int leng = setCollection.getSetSums().size();
        ArrayList<Boolean> added;
        Request temporary;
        Queue<ArrayList<Boolean>> q = new LinkedList<>();
        Queue<Request> requestQueue = new LinkedList<>();


        for (int i = 0; i < leng; i++) {
//            visited.add(new ArrayList<>(Collections.nCopies(request.getSize(), 0)));
//            visited.get(i).set(i, 1);
            added = new ArrayList<>(Collections.nCopies(leng, false));
            added.set(i, true);


            //visited.get(i).set(request.getSize(), i);   // id of requests
            //requests.add(new Request(request.getSize(), request.getStrategy()));



            temporary = request.copy();
            if (!setCollection.getSetSums().get(i).hasNew(temporary))
                continue;

            setCollection.getSetSums().get(i).solve(temporary);

            if (temporary.finished()) {
                System.out.println(setCollection.getSetSums().get(i).getId());
                return;
            }

            requestQueue.add(temporary);
            q.add(added);
        }

        ArrayList<Boolean> helper;
        Request helper2;
        int last;

        while (!q.isEmpty()) {

            temporary = requestQueue.peek();
            last = findLast(q.peek());

            for (int i = last + 1; i < leng; i++) {

                assert q.peek() != null;
                // tu bylo wczesniej added = q.peek();
                if (!q.peek().get(i) && setCollection.getSetSums().get(i).hasNew(temporary)) {     // if i-th set wasn't added
                    added = new ArrayList<>(q.peek());

                    assert temporary != null;
                    helper2 = temporary.copy();


                    setCollection.getSetSums().get(i).solve(helper2);
                    added.set(i, true);

                    if (helper2.finished()) {
                        printOutput(added, setCollection);
                        return;
                    }

                    q.add(added);
                    requestQueue.add(helper2);
                }
            }

            q.remove();
            requestQueue.remove();

        }
        System.out.println("0");
    }
}
