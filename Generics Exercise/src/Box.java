public class Box<T> {
    private StringBuilder sb;
    private String text;

    Box(T[] array){
        sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        this.text = sb.toString();
    }

    @Override
    public String toString() {
        System.out.println(STR."java.lang.String: \{this.text}");
        return null;
    }
}
