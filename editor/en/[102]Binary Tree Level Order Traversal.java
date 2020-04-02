//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics Tree Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode end = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            root = deque.poll();
            list.add(root.val);
            if (root.left != null) deque.offer(root.left);
            if (root.right != null) deque.offer(root.right);
            if (end == root) {
                end = deque.peekLast();
                if (lists.size() % 2 == 1)
                    Collections.reverse(list);
                lists.add(list);
                list = new ArrayList<>();
            }

        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
