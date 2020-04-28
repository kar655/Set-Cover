package cover;

public class Naive extends Strategy {

    private static Naive strategy = new Naive();

    private Naive() {
    }

    public static Naive give() {
        return strategy;
    }

    @Override
    public void solve(SetCollection setCollection, Request request) {
        StringBuilder output = new StringBuilder();

        for (SetSum setSum : setCollection.getSetSums()) {
            if (setSum.numberOfNew(request) != 0) {
                output.append(setSum.getId()).append(" ");
                // tu jakies dodanie tych elementow do request
                setSum.solve(request);
            }
        }

        if (request.finished()) {
            output = new StringBuilder(output.substring(0, output.length() - 1)); // remove last space
            System.out.println(output);
        } else {
            System.out.println("0");
        }
    }
}
