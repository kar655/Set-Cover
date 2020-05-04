package cover;

import java.util.ArrayList;

public class Parser {

    private int currentId; // id of current SetSum
    // todo clean 1 - setSeries, 2 - setRange,
    // -1 - nothing, 0 - Set, 1 - SetSeries or SetRange, 3 - request
    private int readingType;
    private SetSum data; // current SetSum
//    private Request result;
    private ArrayList<Integer> current; // list of current numbers to request or set
    private SetCollection universe = SetCollection.give();
    private ArrayList<Strategy> strategies = new ArrayList<>(); // list of strategies

    public Parser() {
        this.currentId = 1;
        this.readingType = -1;
        this.current = new ArrayList<>();
        data = new SetSum(currentId++);
        strategies.add(Exact.give());   // 1 -> 0
        strategies.add(Greedy.give());  // 2 -> 1
        strategies.add(Naive.give());   // 3 -> 2
    }

    private void clear() {
        current = new ArrayList<>();
        readingType = -1;
    }

    public void parseInput(int num) {
        if (readingType == -1) {
            if (num < 0) { // request
                readingType = 3;
                current.add(-num);
            } else if (num > 0) {
                readingType = 0;
                current.add(num);
            } else {    // empty set
                currentId++;
                data.incrId();
            }

        } else if (readingType == 3) {
            current.add(num);
            Request result = new Request(current.get(0), current.get(1) - 1);
            strategies.get(result.getStrategy()).solve(universe, result);
            clear();

        } else if (num == 0) {

            if (current.size() != 0) {

                if (readingType == 0)
                    data.addSet(new SetSingle(current));
                else if (readingType == 1)
                    data.addSet(new SetSeries(current));
                current = new ArrayList<>();
            }

            readingType = -1;
            universe.addSetSum(data);
            data = new SetSum(currentId++);

        } else if (readingType == 0) {
            if (num < 0) {
                readingType = 1;
                current.add(-num);
            } else {
                if (current.size() != 0) {
                    data.addSet(new SetSingle(current));
                    current = new ArrayList<>();
                }
                current.add(num);
            }
        } else if (readingType == 1) {
            if (num < 0) {
                current.add(-num);
                data.addSet(new SetRange(current));
                current = new ArrayList<>();
            } else {
                data.addSet(new SetSeries(current));
                current = new ArrayList<>();
                current.add(num);
            }
            readingType = 0;
        }
    }
}
