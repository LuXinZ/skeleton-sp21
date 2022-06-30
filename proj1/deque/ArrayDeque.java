package deque;


import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>,Iterable<T> {
    T[] items = (T[]) new Object[8];
    int size;
    int nextFirst;
    int nextLast;
    public ArrayDeque() {
        nextFirst = 3 ;
        nextLast =4 ;
        size = 0;
    }
    public ArrayDeque(T i){
        items[3] = i;
        nextFirst = 2 ;
        nextLast = 4;
        size = 1;
    }
    private void resize(int capacity){

        T[] a = (T[]) new Object[capacity];;
        int firstPos = Math.abs(capacity -size) / 2;
        System.arraycopy(items,nextFirst + 1,a,firstPos,size);
        nextFirst = firstPos - 1;
        nextLast = firstPos + size;
        items = a;
    }
    @Override
    public void addFirst(T item) {

        items[nextFirst] = item;
        size +=1 ;
        nextFirst -=1;
        if (nextFirst == -1){
            resize(size  * 2 );// 提升速度
        }
    }

    @Override
    public void addLast(T item) {


        items[nextLast] = item;
        size +=1 ;
        nextLast += 1;
        if (nextLast == items.length ){
            resize(size  * 2 );// 提升速度
        }
    }
    private  void shrinkSize(){
        if (isEmpty()){
            resize(8);
        }else if (items.length / 4 > size && size >=4){
            resize(size *2);
        }

    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        T item = items[nextFirst + 1] ;
        items[nextFirst + 1] = null;
        nextFirst +=1;
        size -=1;
        shrinkSize();
        return item  ;
    }

    @Override
    public T removeLast() {
        T item = items[nextLast-1];
        items[nextLast -1]=null;
        nextLast -=1;
        size -=1;
        shrinkSize();
        return item;
    }

    @Override
    public T get(int index) {
        return items[index+ nextFirst + 1];
    }
    @Override
    public Iterator<T> iterator() {
        return  new ArrayDequeIterator();
    }
    private class ArrayDequeIterator implements Iterator<T>{
        private int index;
        ArrayDequeIterator(){
            index = 0;

        }
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T item = get(index);
            index +=1;
            return item ;
        }
    }
}
