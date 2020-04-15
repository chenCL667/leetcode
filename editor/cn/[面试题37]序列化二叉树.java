//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        this.val = x;
//    }
//}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        res.append("[");
        dfs(root, res);
        res.setCharAt(res.length() - 1, ']');
        return res.toString();
    }

    private void dfs(TreeNode root, StringBuffer res) {
        if (root == null) {
            res.append("null,");
            return;
        }
        res.append(root.val);
        res.append(",");
        dfs(root.left, res);
        dfs(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        StringBuffer tmp = new StringBuffer(data);
//        删除中括号
        tmp.deleteCharAt(tmp.length() - 1);
        tmp.deleteCharAt(0);

        String[] treeData = tmp.toString().split(",");

        TreeNode root = new TreeNode(0);
        constructTree(root, treeData, 0);
        return root;
    }

    //    [1,2,3,null,null,4,5]
    private void constructTree(TreeNode root, String[] treeData, int index) {
        if (treeData.length == index) {
            return;
        }

        if (!treeData[index].equals("null")) {
            int data = Integer.parseInt(treeData[index]);
            root = new TreeNode(data);
            constructTree(root.left, treeData, index + 1);
            constructTree(root.right, treeData, index + 2);
        } else {
            root = null;
            return;
        }

    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//
//        new Codec().serialize();
//        System.out.println(root);
//    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
