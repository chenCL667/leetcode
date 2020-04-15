//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
//        暴力法
//        int cnt = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) cnt++;
//            if (nums[i] > target) break;
//        }
//        return cnt;

//        二分法计数
//        return targetCnt(0, nums.length - 1, target, nums);

//        二分法找target的边界
        int begin = 0;
        int end = nums.length - 1;
        int mid = 0;
        int left = 0, right = 0;
//        寻找left
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] >= target) end = mid - 1;
            else begin = mid + 1;
        }
        left = end;

        begin = 0;
        end = nums.length - 1;
        mid = 0;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] <= target) begin = mid + 1;
            else end = mid - 1;
        }
        right = begin;
        return right - left - 1;
    }

    private int targetCnt(int begin, int end, int target, int[] nums) {
        if (nums.length == 0) return 0;
        if (begin > end) return 0;
        if (begin == end) {
            if (target == nums[begin])
                return 1;
            else return 0;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] > target) return targetCnt(begin, mid, target, nums);
        else if (nums[mid] < target) return targetCnt(mid + 1, end, target, nums);
        else return targetCnt(begin, mid, target, nums) + targetCnt(mid + 1, end, target, nums);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
