public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();
        jar.add(1);
        jar.add(4);
        jar.remove();
        jar.get();
    }
}