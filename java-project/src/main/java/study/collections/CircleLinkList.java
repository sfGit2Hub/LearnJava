package study.collections;

/**
 * Created by SF on 2017/12/20.
 */
public class CircleLinkList<T> {
    Node head, tail;
    Node p;
    int size = 0;

    public CircleLinkList() {
        this.head = null;
        tail = head;
        p = head;
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

    private class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}