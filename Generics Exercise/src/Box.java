public class Box<T> {
    private T[] array;

    Box(T[] array){
        this.array = array;
    }

    @Override
    public String toString() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(STR."\{this.array[i].getClass().getName()}: \{this.array[i]}");
        }
        return null;
    }
}
