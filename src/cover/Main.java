package cover;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        // 0 - zbior
        // 1 - przedzial
        // 2 - szereg

        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
//        SetCollection universe = SetCollection.give();
//        ArrayList<Strategy> strategies = new ArrayList<>();
//        strategies.add(Naive.give());
//        Request request;

        while (true) {
            parser.parseInput(in.nextInt());
//            try {
//                parser.parseInput(in.nextInt());
//            } catch (Exception e) {
//                break;
//            }

//            if (parser.whatAction() == 1)
//                universe.addSetSum(parser.giveSet());
//            else if (parser.whatAction() == 2) {
//                request = parser.giveRequest();
//                strategies.get(request.getStrategy()).solve(universe, request);
//            }
        }
    }
}
