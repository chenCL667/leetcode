//Given a binary tree, check whether it is a mirror of itself (ie, symmetric aro
//und its center). 
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
//
// 
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// But the following [1,2,2,null,3,null,3] is not: 
//
// 
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// Note: 
//Bonus points if you could solve it both recursively and iteratively. 
// Related Topics Tree Depth-first Search Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B != null) return false;
        if (A != null && B == null) return false;
        if (A == null && B == null) return true;
        if (A.val != B.val) return false;
        return isSameTree(A.left, B.right) && isSameTree(A.right, B.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
