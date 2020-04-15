//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int mid = 0, begin = 0, end = nums.length - 1;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[begin] == target) return begin;
            if (nums[end] == target) return end;
//            如果左半边数据有序
            if (nums[begin] < nums[mid]) {
                if (target > nums[begin] && target < nums[mid])  end = mid - 1;
                else begin = mid + 1;
            }
//            如果右半边数据有序
            else {
                if (target > nums[mid] && target < nums[end])  begin = mid + 1;
                else end = mid - 1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
