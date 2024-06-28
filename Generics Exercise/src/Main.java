import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(10,20);
        System.out.println(scale.getHeavier());

        Scale<String> scale2 = new Scale<>("No", "Hello");
        System.out.println(scale2.getHeavier());
    }
}