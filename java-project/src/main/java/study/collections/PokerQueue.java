package study.collections;

/**
 * Created by Administrator on 2017/12/20.
 */
public class PokerQueue {
    public class Node {
        int data;
        Node next;

        public Node(int ele) {
            this.data = ele;
        }

        public Node(int ele, Node next) {
            this.data = ele;
            this.next = next;
        }
    }

    private Node head, tail, current, pre;
    private int size = 0;
    private int[] result;
    private int deletTimes = 0;

    public PokerQueue(int length) {
        result = new int[length];
    }

    public void add(int ele) {
        Node node = new Node(ele);
        if (head == null) {
            head = node;
            tail = head;
        } else if (head != null && tail == head) {
            tail = node;
            head.next = node;
            tail.next = head;
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void deleteCurrent() {
        result[deletTimes++] = current.data;
        pre.next = current.next;
        current = current.next;
        size--;
    }

    public void nextNode() {
        pre = current;
        current = current.next;
    }

    public void initPreAndCurrent() {
        pre = head;
        current = head;
    }

    public int[] getResult() {
        return result;
    }

    public static int[] doAction(int length, int step) {
        if (step < 1) {
            throw new IllegalArgumentException("step must bigger than 1");
        }
        long starInit = System.currentTimeMillis();
        PokerQueue queue = new PokerQueue(length);
        for (int i = 1; i <= length; i++) {
            queue.add(i);
        }
        System.out.println("init queue use time millis: " + (System.currentTimeMillis()-starInit));
        int j = 1;
        queue.initPreAndCurrent();
        long startRemove = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            if (j % (step+1) == 0) {
                queue.deleteCurrent();
                j = 1;
            }
            queue.nextNode();
            j++;
        }
        System.out.println("execute remove time: " + (System.currentTimeMillis() - startRemove));
        return queue.getResult();
    }

    public static void main(String []args){
        int[] result = doAction(20, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
