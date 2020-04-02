//Given a binary tree and a sum, determine if the tree has a root-to-leaf path s
//uch that adding up all the values along the path equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
// 
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. 
//
// Related Topics Tree Depth-first Search


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
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (sum == 0) return true;
        if (root == null) return false;
        return pathRecur(root, sum);
    }

    private boolean pathRecur(TreeNode root, int sum) {
        if (root == null) return false;
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        if (sum - root.val != 0 && root.left == null && root.right == null) {
            return false;
        }

        return pathRecur(root.left, sum - root.val) || pathRecur(root.left, sum - root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
