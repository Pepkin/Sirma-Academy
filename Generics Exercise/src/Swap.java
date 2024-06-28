import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Swap<T> {
    private List<T> list;
    private int findex;
    private int sindex;
    Swap(List<T> list, int findex, int sindex){
        this.list = list;
        this.findex = findex;
        this.sindex = sindex;
    }

    @Override
    public String toString() {
        Collections.swap(this.list, findex, sindex);
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(STR."\{this.list.get(i).getClass().getName()}: \{this.list.get(i)}");
        }
        return null;
    }
}
