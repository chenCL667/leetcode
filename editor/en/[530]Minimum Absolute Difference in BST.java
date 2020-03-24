//Given a binary search tree with non-negative values, find the minimum absolute
// difference between values of any two nodes. 
//
// Example: 
//
// 
//Input:
//
//   1
//    \
//     3
//    /
//   2
//
//Output:
//1
//
//Explanation:
//The minimum absolute difference is 1, which is the difference between 2 and 1 
//(or between 2 and 3).
// 
//
// 
//
// Note: 
//
// 
// There are at least two nodes in this BST. 
// This question is the same as 783: https://leetcode.com/problems/minimum-dista
//nce-between-bst-nodes/ 
// 
// Related Topics Tree


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
//    解法1：
//    先用深搜的方法遍历树，然后将该树的所有元素存到数组中进行排序，最后求出排序后的数组中相邻数字的最小差值
//    public int getMinimumDifference(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        dfs(root, list);
//        Collections.sort(list);
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i < list.size(); i++) {
//            min = Math.min(min, list.get(i)-list.get(i-1));
//        }
//        return min;
//    }
//
//    private void dfs(TreeNode root, List<Integer> list) {
//        if (root == null) return;
//        list.add(root.val);
//        dfs(root.left, list);
//        dfs(root.right, list);
//    }

    //    解法2：
//    先用中序遍历求出所有元素
//    一次遍历，求出相邻数字的差值
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
