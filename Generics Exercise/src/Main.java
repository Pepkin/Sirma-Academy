import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int commands = Integer.parseInt(sc.nextLine());
        List list = new ArrayList<>();

        for (int i = 0; i < commands; i++) {
            String input = sc.nextLine();

            try{
                list.add(Integer.parseInt(input));
            }catch(NumberFormatException e){
                list.add(input);
            }
        }

        String[] indexes = sc.nextLine().split(" ");
        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);

        Swap swap = new Swap<>(list, firstIndex, secondIndex);

        swap.toString();
    }
}