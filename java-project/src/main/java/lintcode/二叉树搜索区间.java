package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 二叉树搜索区间 {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
//        compareAdd(root, k1, k2, results);
        compareAdd2(root, k1, k2, results);
        Collections.sort(results);
        return results;
    }

    private static void compareAdd(TreeNode node, int k1, int k2, List<Integer> results) {
        if (node == null) {
            return;
        }
        if (node.val >= k1 && node.val <= k2) {
            results.add(node.val);
        }
        compareAdd(node.left, k1, k2, results);
        compareAdd(node.right, k1, k2, results);
    }

    private static void compareAdd2(TreeNode node, int k1, int k2, List<Integer> results) {
       if (node.val < k1 && node.right != null) {
           compareAdd2(node.right, k1, k2, results);
       } else if (node.val > k2 && node.left != null) {
           compareAdd2(node.left, k1, k2, results);
       } else {
           if (node.left != null) {
               compareAdd2(node.left, k1, k2, results);
           }
           if (node.val >= k1 && node.val <= k2) {
               results.add(node.val);
           }
           if (node.right != null) {
               compareAdd2(node.right, k1, k2, results);
           }
       }
    }

    private static void addLesser(TreeNode node, List<Integer> results) {
        results.add(node.val);
        if (node.left == null) {
            return;
        }
        addLesser(node.left, results);
    }


    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(22);
        System.out.println(searchRange(root, 10, 22));

    }
}
