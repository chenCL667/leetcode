//Given a matrix of m x n elements (m rows, n columns), return all elements of t
//he matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return new ArrayList<Integer>();
        int left = 0, right = matrix[0].length - 1, top = 0, buttom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();

        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > buttom) break;

            for (int i = top; i <= buttom; i++) res.add(matrix[i][right]);
            if (--right < left) break;

            for (int i = right; i >= left; i--) res.add(matrix[buttom][i]);
            if (--buttom < top) break;

            for (int i = buttom; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
