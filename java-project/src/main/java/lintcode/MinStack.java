package lintcode;

public class MinStack {
    class Node {
        int ele;
        Node pre;
        Node(int num, Node pre) {
            this.ele = num;
            this.pre = pre;
        }
    }

    private Node tail;
    private int min;

    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        this.tail = new Node(number, tail);
        if (tail.pre == null) {
            min = number;
        } else {
            if (min > number) {
                min = number;
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (tail == null) return 0;
        int ele = this.tail.ele;
        this.tail = this.tail.pre;
        if (ele == min) {
            min = findMin();
        }
        return ele;
    }

    private int findMin() {
        if (tail == null) return 0;
        if (tail.pre == null) return tail.ele;

        Node node = tail;
        int min = node.ele;
        while (node.pre != null) {
            if (min > node.pre.ele) {
                min = node.pre.ele;
            }
            node = node.pre;
        }
        return min;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min;
    }

    public static void main(String[] args) {
        /*
        push(-100)
        push(-101)
        push(-99)
        min()
        push(100)
        min()
        push(50)
        min()
        pop()
        pop()
        pop()
        pop()
        pop()
        push(0)
        min()
         */
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(-1);
        minStack.push(-99);
        System.out.println(minStack.min());
        minStack.push(10);
        System.out.println(minStack.min());
        minStack.push(10);
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        minStack.push(0);
        System.out.println(minStack.min());


    }
}
