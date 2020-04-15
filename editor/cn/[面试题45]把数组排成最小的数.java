//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        if (nums.length == 0) return "";
        StringBuffer first = new StringBuffer();
        StringBuffer second = new StringBuffer();
        int tmp = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                first.setLength(0);
                second.setLength(0);
                first.append(nums[j]).append(nums[j + 1]);
                second.append(nums[j + 1]).append(nums[j]);
                if (first.compareTo(second) > 0) {
                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        first.setLength(0);
        for (int num : nums) {
            first.append(num);
        }

        return first.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
