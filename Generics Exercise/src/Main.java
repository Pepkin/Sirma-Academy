import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();

        while (true) {
            String input = scanner.nextLine();
            String[] commandParts = input.split(" ");
            String command = commandParts[0];

            if (command.equals("end")) {
                break;
            }

            switch (command) {
                case "Add":
                    list.add(commandParts[1]);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandParts[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    System.out.println(list.contains(commandParts[1]));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(commandParts[1]);
                    int index2 = Integer.parseInt(commandParts[2]);
                    list.swap(index1, index2);
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(commandParts[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }

        scanner.close();
    }
}
