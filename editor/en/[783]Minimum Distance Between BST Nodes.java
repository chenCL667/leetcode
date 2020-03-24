//Given a Binary Search Tree (BST) with the root node root, return the minimum d
//ifference between the values of any two different nodes in the tree. 
//
// Example : 
//
// 
//Input: root = [4,2,6,1,3,null,null]
//Output: 1
//Explanation:
//Note that root is a TreeNode object, not an array.
//
//The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//while the minimum difference in this tree is 1, it occurs between node 1 and n
//ode 2, also between node 3 and node 2.
// 
//
// Note: 
//
// 
// The size of the BST will be between 2 and 100. 
// The BST is always valid, each node's value is an integer, and each node's val
//ue is different. 
// This question is the same as 530: https://leetcode.com/problems/minimum-absol
//ute-difference-in-bst/ 
// 
// Related Topics Tree Recursion


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int minDiffInBST(TreeNode root) {
//        理解错了题意，下面代码实现是相邻节点（父节点和子节点）直接的差值，而不是题意要求的任意节点的差值
//        if (root == null) return Integer.MAX_VALUE;
//        if (root.left != null && root.right == null)
//            return Math.min(Math.abs(root.val - root.left.val), minDiffInBST(root.left));
//        if (root.right != null && root.left == null)
//            return Math.min(Math.abs(root.val - root.right.val), minDiffInBST(root.right));
//        if (root.left != null && root.right != null) {
//            int min = Math.min(Math.abs(root.val - root.left.val), Math.abs(root.val - root.right.val));
//            min = Math.min(min, minDiffInBST(root.left));
//            min = Math.min(min, minDiffInBST(root.right));
//            return min;
//        }
//        return Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i)-list.get(i-1));
        }
        return min;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
