package lintcode;

public class 二叉树序列化 {
    private static int index = -1;
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        // write your code here
        StringBuilder s = new StringBuilder();
        if(root == null){
            s.append("#,");
            return s.toString();
        }
        s.append(root.val+",");
        s.append(serialize(root.left));
        s.append(serialize(root.right));
        return s.toString();
    }


    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        // write your code here
        String[] nodes = data.split(",");
        TreeNode root = deserialize(nodes);
        return root;
    }

    public static TreeNode deserialize(String []data) {
        index++;
        if (data[index].equals("#")) {
            return null;
        }
        TreeNode leave = new TreeNode(Integer.valueOf(data[index]));
        leave.left = deserialize(data);
        leave.right = deserialize(data);
        return leave;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(serialize(root));

        TreeNode rootSource = deserialize("1,2,3,#,#,#,4,6,#,#,5,#,#,");
        System.out.println(rootSource);
    }

//      Definition of TreeNode:
      public static class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
     }
}
