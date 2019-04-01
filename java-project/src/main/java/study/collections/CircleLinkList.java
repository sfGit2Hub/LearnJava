package study.collections;

import java.util.Iterator;

/**
 * Created by SF on 2017/12/20.
 */
public class CircleLinkList<T> implements Iterable<T>{
    Node<T> head, tail;
    Node<T> p;
    int size = 0;
    T[] result;

    public CircleLinkList(int size) {
        this.head = null;
        tail = head;
        p = head;
        result = (T[]) new Object[size];
    }

    public int length() {
        return size;
    }

    /**
     * 添加节点
     *
     * @param data
     */
    public void add(T data) {
        Node node = new Node<T>(data);
        if (head == null) {
            head = node;
            tail = head;
            p = head;
            size++;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
            p = head;
            size++;
        }
    }


    /**
     * 得到数据
     *
     * @param index
     * @return
     */
    public T get(int index) {
        int i = 0;
        p = head;
        while (i != index && p != tail) {
            i++;
            p = p.next;
        }
        return (T) p.data;
    }

    /**
     * 不带头结点的头插法，所谓不带头结点是指不带为空的头结点。
     * 所以判断链表为空的条件不一样
     *
     * @return
     */
    public boolean isEmpty() {
        if (head != null)
            return false;
        else
            return true;
    }

    public T[] getResult() {
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircleLinkListIterator();
    }

    private class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    private class CircleLinkListIterator implements Iterator<T> {
        private Node<T> current = (Node<T>) p;
        private int resultIndex = 0;

        @Override
        public boolean hasNext() {
            return isEmpty();
        }

        @Override
        public T next() {
            return (T) p.next.data;
        }

        @Override
        public void remove() {
            if (p.next != null) {
                p.next = p.next.next;
                size--;
                result[resultIndex++] = (T) p.next.data;
            }
        }
    }
}