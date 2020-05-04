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
            if (setSum.hasNew(request)) {

                setSum.solve(request);
                output.append(setSum.getId());

                if (request.finished()) {
                    System.out.println(output);
                    return;
                }

                output.append(" ");
            }
        }

        System.out.println("0");
    }
}
