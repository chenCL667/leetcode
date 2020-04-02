//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
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
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search


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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, lists, sum, list);
        return lists;
    }

    private void dfs(TreeNode root, List<List<Integer>> lists, int sum, List<Integer> list) {
        list.add(root.val);
        // if (sum - root.val < 0) return;
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList(list));
            return;
        }

        if (root.left != null) {
            dfs(root.left, lists, sum - root.val, list);
            if (!list.isEmpty())
                list.remove(list.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, lists, sum - root.val, list);
            if (!list.isEmpty())
                list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
