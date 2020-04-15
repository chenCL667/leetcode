//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    滑动窗口
    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        int small = 1;
        int big = 2;
        while (small < big) {
            if (sum(small, big) == target) {
                int[] slideWindow = new int[big - small + 1];
                setList(slideWindow, small, big);
                lists.add(slideWindow);
                small++;
            } else if (sum(small, big) > target) small++;
            else big++;
        }
        int[][] res = new int[lists.size()][];
        return lists.toArray(res);
    }

    private int sum(int begin, int end) {
        return (begin + end) * (end - begin + 1) / 2;
    }

    private void setList(int[] list, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            list[i - begin] = i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
