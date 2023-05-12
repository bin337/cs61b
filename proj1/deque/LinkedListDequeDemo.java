package deque;
public class LinkedListDequeDemo<T> {
    private int size;
    private Node sentinel;

    // 内部节点类
    private class Node {
        T item;
        Node prev;
        Node next;

        Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // 构造函数，创建一个空链表
    public LinkedListDequeDemo() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // 添加元素到链表首部
    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    // 添加元素到链表尾部
    public void addLast(T item) {
        Node newNode = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 返回链表的大小
    public int size() {
        return size;
    }

    // 打印链表元素
    public void printDeque() {
        Node curr = sentinel.next;
        while (curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // 删除链表首部的元素，并返回其值
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return item;
    }

    // 删除链表尾部的元素，并返回其值
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return item;
    }

    // 获取链表中指定位置的元素值
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node curr = sentinel.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    // 比较链表是否相等
//    public boolean equals(Object o) {
//        if (!(o instanceof LinkedListDeque)) {
//            return false;
//        }
//        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
//        if (size() != other.size()) {
//            return false;
//        }
//        Node curr1 = sentinel.next;
//        Node curr2 = other.sentinel.next;
//        while (curr1 != sentinel) {
//            if (!curr1.item.equals(curr2.item)) {
//                return false;
//            }
//            curr1 = curr1.next;
//            curr2 = curr2.next;
//        }
//        return true;
//    }
}