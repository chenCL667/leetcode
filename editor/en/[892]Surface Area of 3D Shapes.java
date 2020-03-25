//On a N * N grid, we place some 1 * 1 * 1 cubes. 
//
// Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
// cell (i, j). 
//
// Return the total surface area of the resulting shapes. 
//
// 
//
// 
// 
// 
// 
// 
// 
// 
// 
//
// 
// Example 1: 
//
// 
//Input: [[2]]
//Output: 10
// 
//
// 
// Example 2: 
//
// 
//Input: [[1,2],[3,4]]
//Output: 34
// 
//
// 
// Example 3: 
//
// 
//Input: [[1,0],[0,2]]
//Output: 16
// 
//
// 
// Example 4: 
//
// 
//Input: [[1,1,1],[1,0,1],[1,1,1]]
//Output: 32
// 
//
// 
// Example 5: 
//
// 
//Input: [[2,2,2],[2,1,2],[2,2,2]]
//Output: 46
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 50 
// 0 <= grid[i][j] <= 50 
// 
// 
// 
// 
// 
// 
// Related Topics Math Geometry


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int surfaceArea(int[][] grid) {
//        计算上下底面面积和所有的侧面积
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    area += 2;
                    area += (grid[i][j] * 4);
                }
            }
        }

        int left = 0;
        int right = 0;
//        计算贴合的侧面积，从area里面减去贴合的侧面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && grid[i][j - 1] != 0) {
                    area -= (Math.min(grid[i][j], grid[i][j - 1]) * 2);
                    left += (Math.min(grid[i][j], grid[i][j - 1]) * 2);
                }
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && grid[i - 1][j] != 0) {
                    area -= (Math.min(grid[i][j], grid[i - 1][j]) * 2);
                    right += (Math.min(grid[i][j], grid[i - 1][j]) * 2);
                }
            }
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
