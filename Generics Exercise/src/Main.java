import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Integer[] intArray = ArrayCreator.create(5, 42);
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        String[] strArray = ArrayCreator.create(String.class, 3, "Hello");
        for (String str : strArray) {
            System.out.print(str + " ");
        }
    }
}