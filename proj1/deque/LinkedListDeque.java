package deque;

public class LinkedListDeque<T> {
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
        if (sentinel.pre == null && sentinel.next == null) {
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
        for (int j = 0; j <= size; j++) {
            p=p.next;
            System.out.println(p+" ");
        }
    }

    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        Node node=sentinel;
        Node node1=sentinel.next;
        node.next=node.next.next;
        node.next.next.pre=node;
        size--;
        return node1.item;
    }

    public T removeLast() {
        return null;
    }

    public T get(int index) {
        if(isEmpty()){
            return null;
        }
        Node node=sentinel.pre;
        sentinel.pre=node.pre;
        node.pre=sentinel;
        size--;
        return node.item;
    }

        public Iterator<T> iterator(){
        return null;
    }
    public boolean equals(Object o) {
        return false;
    }

}
