package deque;


import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MaxArrayDeque<T> extends  ArrayDeque<T>{
    Comparator<T> com ;
    public MaxArrayDeque(Comparator<T> c){
        super();
        com = c;
    }
    public T max(){
        return max(com);
    }

    public T max(Comparator<T> c){
        int maxIndex = 0 ;
        int i =0;
        while (i < size()){
            if (c.compare(get(i),get(maxIndex)) > 0){
                maxIndex = i;
            }
            i +=1;
        }
        return get(maxIndex);
    }



}
