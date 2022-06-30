package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    public int size;
    public Node sentinel;
    public Node endSentinel;
    public class Node {
        public T item;
        public Node next;
        public Node prev;
        public Node(T i, Node n){
            item = i;
            next = n ;
        }
    }
    public LinkedListDeque(){
        sentinel = new Node(null,null);
        endSentinel = sentinel;
        size = 0;
    }
    public T getRecursive(int index) {
        return null;
    }
    @Override
    public void addFirst(T item) {
        Node first  = new Node(item,sentinel.next);
        sentinel.next = first;
        first.prev = sentinel;
        if(first.next == null){
            endSentinel = first;
        }

        size +=1;
    }

    @Override
    public void addLast(T item) {
        Node p = endSentinel;
        endSentinel.next  =new Node(item,null);

        endSentinel = endSentinel.next;
        endSentinel.prev = p;
        size+=1;
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
        if (size == 0) {
           return null;
        }
        Node next = sentinel.next;
        sentinel = next;
        size -=1;
        return next.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
           return null;
        }
        Node p = endSentinel;
        endSentinel = endSentinel.prev;
        size -=1;
        return p.item;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
