//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<String> ans = new ArrayList<>();
//    StringBuffer path = new StringBuffer();
//
//    public List<String> binaryTreePaths(TreeNode root) {
//        if (root == null) return ans;
//        dfs(root);
//        return ans;
//    }
//
//    private void dfs(TreeNode root) {
//        path.append(root.val);
//        if (root.left == null && root.right == null) {
//            ans.add(new String(path.toString()));
//            path.append("->");
//            return;
//        }
//        path.append("->");
//        if (root.left != null) {
//            dfs(root.left);
//            int tmp = root.left.val;
//            if (tmp < 0) path.deleteCharAt(path.length() - 1);
//            while (tmp != 0) {
//                tmp = tmp / 10;
//                path.deleteCharAt(path.length() - 1);
//            }
//            path.deleteCharAt(path.length() - 1);
//            path.deleteCharAt(path.length() - 1);
//        }
//        if (root.right != null) {
//            dfs(root.right);
//            int tmp = root.right.val;
//            if (tmp < 0) path.deleteCharAt(path.length() - 1);
//            while (tmp != 0) {
//                tmp = tmp / 10;
//                path.deleteCharAt(path.length() - 1);
//            }
//            path.deleteCharAt(path.length() - 1);
//            path.deleteCharAt(path.length() - 1);
//        }
//    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        String path = new String();
        getPath(root, path);
        return ans;
    }

    private void getPath(TreeNode root, String path){
        path += root.val;
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        path += "->";
        if (root.left != null) {
            getPath(root.left, path);
        }
        if (root.right != null) {
            getPath(root.right, path);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
