package cover;

import java.util.ArrayList;

public class Parser {

    private int currentId;
    // -1 - nothing, 0 - setSingle or set, 1 - setSeries, 2 - setRange, 3 - request
    private int readingType;
    private SetSum data;
    private Request result;
    private ArrayList<Integer> current;
    private SetCollection universe = SetCollection.give();
    private ArrayList<Strategy> strategies = new ArrayList<>();

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
//        current.clear();
        current = new ArrayList<>();
        readingType = -1;
    }


    public SetSum giveSet() {
        SetSum old = data;
        data = new SetSum(currentId++);
        return old;
    }

    public Request giveRequest() {
        return result;
    }

    public void parseInput(int num) {
        if (readingType == -1) {
            if (num < 0) { // request
                readingType = 3;
                current.add(-num);
//                System.out.println("Poczatek requesta " + current);
            } else if (num > 0) {
                readingType = 0;
                current.add(num);
//                System.out.println("Poczatek Set-a "  + current);
            } else {    // empty set
//                System.out.println("Pusty set");
                currentId++;
                data.incrId();
            }
        } else if (readingType == 3) {
//            System.out.println("Request od 1 do " + current + " strategia " + num);
            current.add(num);
            result = new Request(current.get(0), current.get(1) - 1);
            strategies.get(result.getStrategy()).solve(universe, result);
            clear();
        } else if (num == 0) {
            // buduje set niedokonczony (np nie wiedzialem czy otrzymam koljna -cos) i dodaje to data
            // todo czy ostatni > 0 czy < 0
//            System.out.println("Buduje jesli nie pusty " + current);
            if (current.size() != 0) {

                if (readingType == 0)
                    data.addSet(new SetSingle(current));
                else if (readingType == 1)
                    data.addSet(new SetSeries(current));
                current = new ArrayList<>();
            }

            readingType = -1;
            universe.addSetSum(data);
//            System.out.println("ADDED ID " +( currentId - 1));
            data = new SetSum(currentId++);
        } else if (readingType == 0) {
            if (num < 0) {
                readingType = 1;
                current.add(-num);
//                System.out.println("To nie bedzie zwykly SetSingle " + current);
            } else {
//                System.out.println("Zbudowalem SetSingle jesli nie pusty " + current + " dopudowuje do niego dalej");
                data.addSet(new SetSingle(current));
                current = new ArrayList<>();
                current.add(num);
            }
        } else if (readingType == 1) {
            if (num < 0) {
                current.add(-num);
//                System.out.println("Buduje SetRamge " + current);
                data.addSet(new SetRange(current));
                current = new ArrayList<>();
            } else {
//                System.out.println("Buduje SetSeries " + current);
                data.addSet(new SetSeries(current));
                current = new ArrayList<>();
                current.add(num);
            }
            readingType = 0;
        }
    }
}
