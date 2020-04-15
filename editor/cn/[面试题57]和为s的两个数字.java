//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    双指针法
//    public int[] twoSum(int[] nums, int target) {
//        int front = 0;
//        int rear = nums.length - 1;
//        int[] res = new int[2];
//        while (front < rear) {
//            while (nums[front] + nums[rear] > target) rear--;
//            if (front < rear && nums[front] + nums[rear] == target) {
//                res[0] = nums[front];
//                res[1] = nums[rear];
//                break;
//            }
//            while (nums[front] + nums[rear] < target) front++;
//            if (front < rear && nums[front] + nums[rear] == target) {
//                res[0] = nums[front];
//                res[1] = nums[rear];
//                break;
//            }
//        }
//        return res;
//    }

    //    双指针法，整理版
    public int[] twoSum(int[] nums, int target) {
        int front = 0;
        int rear = nums.length - 1;
        int[] res = new int[2];
        while (front < rear) {
            if (nums[front] + nums[rear] == target) {
                res[0] = nums[front];
                res[1] = nums[rear];
                break;
            }
            else if (nums[front] + nums[rear] > target) rear--;
            else front++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
