import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int commands = Integer.parseInt(sc.nextLine());
        var comparedValue = sc.nextLine();
        List list = new ArrayList<>();

        for (int i = 0; i < commands; i++) {
            var input = sc.nextLine();

            list.add(input);
        }

        Counter counter = new Counter<>(list, comparedValue);

        counter.toString();
    }
}