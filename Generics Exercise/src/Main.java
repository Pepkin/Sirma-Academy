import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int commands = Integer.parseInt(sc.nextLine());
        List<Box> list = new ArrayList<>();

        for (int i = 0; i < commands; i++) {
            String[] input = sc.nextLine().split(" ");
            Box<String> box = new Box<>(input);
            list.add(box);
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).toString();
        }
    }
}