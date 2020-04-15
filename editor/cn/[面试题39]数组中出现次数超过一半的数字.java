//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            }
//            else map.put(nums[i], 1);
//
//            if (map.get(nums[i]) >= (nums.length + 1) /2 ) {
//                res = nums[i];
//                break;
//            }
//        }
//        return res;

        int vote = 0;
        int target = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) target = nums[i];
            if (target == nums[i]) vote++;
            else if (target != nums[i]) vote--;
        }
        return target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
