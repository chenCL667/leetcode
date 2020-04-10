//给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 输入: [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 注意: 给定的二进制数组的长度不会超过50000。 
// Related Topics 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cnt = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cnt--;
            else cnt++;

            if (map.containsKey(cnt)) {
                maxLength = Math.max(maxLength, i - map.get(cnt));
            }else {
                map.put(cnt, i);
            }

        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
