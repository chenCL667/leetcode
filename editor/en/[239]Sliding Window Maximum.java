//Given an array nums, there is a sliding window of size k which is moving from 
//the very left of the array to the very right. You can only see the k numbers in 
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window. 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty arr
//ay. 
//
// Follow up: 
//Could you solve it in linear time? Related Topics Heap Sliding Window


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        1、暴力法，直接遍历所有的滑动窗口，然后依次找出每个窗口的最大值，时间复杂度为O(n*k)，空间复杂度为O(n)
//        if (nums.length == 0) {
//            return nums;
//        }
//
//        int[] res = new int[nums.length - k + 1];
//        for (int i = 0; i < (nums.length - k + 1); i++) {
//            res[i] = Integer.MIN_VALUE;
//            for (int j = i; j < k + i; j++) {
//                res[i] = Math.max(res[i], nums[j]);
//            }
//        }
//        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
