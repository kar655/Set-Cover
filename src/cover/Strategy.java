package cover;

public abstract class Strategy {

    // solves request using setCollection as universe
    // prints "0" if it can't be done
    // else ids of used SetSums in lexicographic order
    public abstract void solve(SetCollection setCollection, Request request);
}
