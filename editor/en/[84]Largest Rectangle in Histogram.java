//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
//        1、暴力法
//        int area = 0;
//        int max = 0;
//        int min;
//        if (heights.length == 1) return heights[0];
//        for (int i = 0; i < heights.length; i++) {
//            min = Integer.MAX_VALUE;
//            for (int j = i; j < heights.length; j++) {
//                min = Math.min(min, heights[j]);
//                area = (j - i + 1) * min;
//                max = Math.max(max, area);
//            }
//        }
//        return max;

//        2、分治法
        return calMaxArea(heights, 0 , heights.length);
    }

    public int calMaxArea(int[] heights, int start, int end) {
        if (start >= end) return 0;
        int minHeights = Integer.MAX_VALUE;
        int minIndex = start;
        for (int i = start; i < end; i++) {
            minHeights = Math.min(minHeights, heights[i]);
            minIndex = (minHeights == heights[i]) ? i : minIndex;
        }
        System.out.println("minHeights:" + minHeights);
        return Math.max(minHeights * (end - start), Math.max(calMaxArea(heights, start, minIndex), calMaxArea(heights, minIndex + 1, end)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
