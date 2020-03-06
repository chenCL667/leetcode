//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// Example 1: 
//
// 
//Input: [1,2,3,4,5,6,7] and k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: [-1,-100,3,99] and k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// Note: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
//        1、开辟额外的存储空间，时间复杂度O(n)，空间复杂度O(n)
//        int[] tmp= new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            tmp[(i+k)%nums.length]=nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i]=tmp[i];
//        }

//        2、不开辟额外的数组，时间复杂度为O(nk)，空间复杂度为O(1)
//        int tmp = 0;
//        k = k % nums.length;
//        for (int i = 0; i < k; i++) {
//            tmp = nums[nums.length - 1];
//            for (int j = nums.length - 1; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = tmp;
//        }

//        3、思路：最终效果是将原数组最后的k个数倒置，然后放到数组前面，
//        再将前面的n-k个数倒置，然后放在数组最后的n-k个位置.
//        时间复杂度O(),空间复杂度O(1)
        k = k % nums.length;
        rerverse(nums, 0, nums.length-1);
        rerverse(nums, 0, k - 1);
        rerverse(nums, k, nums.length-1);
    }

    private void rerverse(int[] nums, int start, int end) {
       while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
