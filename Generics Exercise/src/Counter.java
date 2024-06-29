import java.util.List;

public class Counter<T extends Comparable<T>>  {
    private List<T> list;
    private T compareValue;

    Counter(List<T> list, T comparedValue){
        this.list = list;
        this.compareValue = comparedValue;
    }

    @Override
    public String toString() {
        int count = 0;
        for (var item : list){
            if(item.compareTo(compareValue) > 0){
                count++;
            }
        }

        System.out.println(count);

        return null;
    }
}
