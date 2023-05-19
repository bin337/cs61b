package deque;
import java.util.Iterator;

public class ArrayDeque<Item> implements Deque<Item>{
    public Item[] items;
    private int size;
    public int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items=(Item[])new Object[8];
        size=0;
        nextFirst=0;
        nextLast=1;
    }

    private void resize (double scale){
        Item[] a = (Item[]) new Object[(int)(items.length*scale)];

        if (scale>1){
            for (int i=0;i<size;i++){
                a[i]=items[(i+nextFirst+1)%items.length];
            }
        }
        else{
            for (int i=0;i<size;i++){
                a[i]=items[(i+nextFirst+1)%items.length];
            }
        }
        items = a;
    }

    public void addFirst(Item x){
        items[nextFirst]=x;
        nextFirst=((nextFirst-1)+items.length)%items.length;
        size++;
        if (size == items.length) {
            resize(2.0);
            nextFirst=items.length-1;
            nextLast=size;
        }
    }

    public void addLast(Item x){
        items[nextLast]=x;
        nextLast=(nextLast+1)%items.length;
        size++;
        if (size == items.length) {
            resize(2.0);
            nextFirst=items.length-1;
            nextLast=size;
        }
    }


    public boolean isEmpty(){
        return (size==0);
    }

    public int size(){
        return size;
    }

    public void printDeque(){

        for (int i= (nextFirst+1)%items.length;i!=nextLast;i++,i=i%items.length){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }



    public Item removeFirst(){
        if (size==0){
            return null;
        }
        if (size==items.length/2){
            resize(1.0/2);
            nextFirst=items.length-1;
            nextLast=items.length;
        }
        Item result=items[(nextFirst+1)%items.length];
        items[(nextFirst+1)%items.length]=null;
        nextFirst=(nextFirst+1)%items.length;
        size--;

        return result;
    }

    public Item removeLast(){
        if (isEmpty()){
            return null;
        }
        if (size==items.length/2){
            resize(1.0/2);
            nextFirst=size-1;
            nextLast=items.length;
        }
        Item result=items[((nextLast+items.length-1)%items.length)];
        items[((nextLast-1)+items.length)%items.length]=null;
        nextLast=((nextLast-1)+items.length)%items.length;
        size--;


        return result;
    }
    public Item get(int index){
        int first=(nextFirst+1)%items.length;
        if (index>size-1){
            return null;
        }
        return items[(first+index)%items.length];
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public int getSize() {
        return items.length;
    }

    public static void main(String[] args) {
        ArrayDeque<String> stringArrayDeque = new ArrayDeque<>();
        stringArrayDeque.addFirst("abc1");
        stringArrayDeque.addFirst("abc2");
        stringArrayDeque.addFirst("abc3");
        stringArrayDeque.addFirst("abc4");
        stringArrayDeque.addFirst("abc5");
        stringArrayDeque.addFirst("abc6");
        stringArrayDeque.addLast("xyz1");
        stringArrayDeque.addLast("xyz2");
        stringArrayDeque.addLast("xyz3");
        stringArrayDeque.addLast("xyz4");
        stringArrayDeque.addLast("xyz5");
        stringArrayDeque.addLast("xyz6");
        stringArrayDeque.addLast("xyz7");
        stringArrayDeque.addLast("xyz8");
        stringArrayDeque.addLast("xyz9");
        stringArrayDeque.addFirst("7");
        stringArrayDeque.addFirst("8");
        stringArrayDeque.addFirst("9");
        stringArrayDeque.removeLast();
        stringArrayDeque.removeLast();
        stringArrayDeque.removeLast();
        stringArrayDeque.removeLast();

    }
}
