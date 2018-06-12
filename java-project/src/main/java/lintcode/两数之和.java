package lintcode;

/**
 * Created by Administrator on 2018/6/11.
 */
public class 两数之和 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNode(l1, l2, 0);
    }

    private static ListNode addTwoNode(ListNode node_1, ListNode node_2, int up) {
        if (node_1 == null || node_2 == null) {
            if (node_1 != null) {
                node_1.val += up;
                return node_1;
            }
            if (node_2 != null) {
                node_2.val += up;
                return node_2;
            }
            return null;
        }
        int sum = node_1.val + node_2.val + up;
        ListNode node;
        if (sum >= 10) {
            node = new ListNode(sum - 10);
            node.next = addTwoNode(node_1.next, node_2.next, 1);
        } else {
            node = new ListNode(sum);
            node.next = addTwoNode(node_1.next, node_2.next, 0);
        }
        return node;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);

    }
}
