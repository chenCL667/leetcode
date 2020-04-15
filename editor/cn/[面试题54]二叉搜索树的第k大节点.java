//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树


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
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(list.size() - k);
    }

    private void dfs(TreeNode root, List<Integer> list){
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
