//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public TreeNode build(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map map) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        if (preorderStart == preorderEnd) return root;
        else {
            int index = (int) map.get(preorder[preorderStart]);
            int leftNode = index - inorderStart;
            root.left = build(preorder, preorderStart + 1, preorderStart + leftNode, inorder, inorderStart, inorderStart + leftNode - 1, map);
            root.right = build(preorder, preorderStart + leftNode + 1, preorderEnd, inorder, index + 1, inorderEnd, map);
            return root;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
