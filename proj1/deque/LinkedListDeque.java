package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T> {
    private int size;
    private Node sentinel;

    public LinkedListDeque() {//constructor
        sentinel = new Node(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    //"-------------------------------------------------------------------------"
    public class Node {//Nested class node
        T item;
        Node pre;
        Node next;

        public Node(Node pre, T item, Node next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    //"----------------------------------------------------------------------"

    public class LinkedListDequeIterator<T> implements Iterator<T> {

        private LinkedListDeque.Node NodePointer;

        public LinkedListDequeIterator(LinkedListDeque.Node sentinel) {
            this.NodePointer = sentinel;
        }

        @Override
        public boolean hasNext() {
            if (NodePointer.next != sentinel) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                NodePointer = NodePointer.next;
                return (T) NodePointer.item;

            }
            return null;
        }
    }

    public void addFirst(T item) {
        Node p = sentinel;
        Node node = new Node(sentinel, item, sentinel.next);
        if (sentinel.next != null) {
            sentinel.next.pre = node;
        }
        sentinel.next = node;

        size += 1;
    }

    public void addLast(T item) {
        Node p = sentinel;
        Node node = new Node(sentinel.pre, item, sentinel);
        if (sentinel.pre != null) {
            sentinel.pre.next = node;
        }
        sentinel.pre = node;

        size += 1;
    }

    public boolean isEmpty() {
        if (sentinel.pre==sentinel) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = size();
        Node p = sentinel;
        for (int j = 0; j < size; j++) {
            p = p.next;
            System.out.print(p.item.toString() + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node node=sentinel.next;
        sentinel.next.next.pre=sentinel;
        sentinel.next=sentinel.next.next;
        size--;
        return node.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node node = sentinel.pre;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return node.item;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        int i = 0;
        Node node = sentinel;
        while (i <= index && sentinel.next != null) {
            node = node.next;
            i++;
        }
        return node.item;
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator<T>(sentinel);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof LinkedListDeque)) return false;
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (size != other.size()) return false;
        Iterator<T> iterThis = iterator();
        Iterator<T> iterOther = other.iterator();
        while (iterThis.hasNext() && iterOther.hasNext()) {
            T elemThis = iterThis.next();
            T elemOther = iterOther.next();
            if (!elemThis.equals(elemOther)) return false;
        }
        return true;
    }

}
