package cover;

public abstract class Strategy {

    protected int added;

    public abstract void solve(SetCollection setCollection, Request request);
}
