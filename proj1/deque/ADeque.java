package deque;

import java.util.Iterator;

public class ADeque<T> implements Deque<T> {

    private T[] ts;
    private int size;
    private int nextfirst;
    private int nextlast;
    private int factor;

    public ADeque() {
        ts = (T[]) new Object[8];
        size = 0;
        nextfirst = 0;
        nextlast = 1;
    }

    @Override
    public void addFirst(T item) {
        ts[nextfirst] = item;
        nextfirst = (nextfirst - 1 + ts.length) % ts.length;//except nextfirst-1 equals zero
        size++;
        if (size == ts.length) {
            resize(2);
        }
    }

    public void resize(double scale) {//根据scale的不同，可放大可缩小
        //resize()后记得要更新nextfirst和nextlast的值
        T[] ts1 = (T[]) new Object[(int) (ts.length * scale)];
        for (int i = 0; i < size; i++) {
            ts1[i] = ts[(nextfirst + 1 + i) % ts.length];

        }
        ts = ts1;
        nextfirst = ts.length - 1;
        nextlast = size;

    }

    @Override
    public void addLast(T item) {
        ts[nextlast] = item;
        nextlast = (nextlast + 1) % ts.length;
        size++;
        if (size == ts.length) {
            resize(2);
        }
    }


    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = (nextfirst + 1 + ts.length) % ts.length; i != nextlast; i++, i = i % ts.length) {
            if(ts[i].toString()!=null){
                System.out.println(ts[i].toString());
            }
        }
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        T t=ts[(nextfirst+1)% ts.length];
        ts[(nextfirst+1)% ts.length]=null;
        nextfirst=(nextfirst+1)% ts.length;
        size--;
        return t;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        T t=ts[(nextlast-1+ts.length)% ts.length];
        ts[(nextlast-1+ts.length)% ts.length]=null;
        nextlast=nextlast-1+ts.length;
        size--;
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public static void main(String[] args) {
        ADeque<String> stringADeque = new ADeque<>();
        stringADeque.addFirst("a5");
        stringADeque.addFirst("b4");
        stringADeque.addFirst("c3");
        stringADeque.addFirst("c2");
        stringADeque.addFirst("c1");
        stringADeque.addLast("k6");
        stringADeque.addLast("k7");
        stringADeque.addLast("k8");
        stringADeque.addLast("k9");
        stringADeque.addLast("k10");
        stringADeque.addLast("k11");
        stringADeque.removeFirst();
        stringADeque.removeFirst();
        stringADeque.removeFirst();
        stringADeque.removeLast();
        stringADeque.removeLast();
        stringADeque.removeLast();
        stringADeque.printDeque();
    }
}
