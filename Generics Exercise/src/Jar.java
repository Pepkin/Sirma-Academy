import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {
    private E item;
    Deque<E> list;

    Jar(){
        this.list = new ArrayDeque<>();
    }

    public void add(E item){
        list.add(item);
    }

    public void remove(){
        list.removeLast();
    }

    public void get() {
        for(E item : list){
            System.out.println(item);
        }
    }
}
