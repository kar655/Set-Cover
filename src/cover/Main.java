package cover;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();

        while (true) {
            try {
                parser.parseInput(in.nextInt());
            } catch (Exception e) {
                break;
            }
        }
    }
}
