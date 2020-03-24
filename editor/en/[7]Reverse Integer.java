//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    重点：如何判断溢出（上溢和下溢），以及如何获取int类型的最大值
    public int reverse(int x) {
        int re = 0;
        while (x != 0) {
            if (re >= 0 && re <= (Integer.MAX_VALUE - (x % 10)) / 10) {
                re = (x % 10) + re * 10;
                x = x / 10;
            } else if (re <= 0 && re >= (Integer.MIN_VALUE - (x % 10)) / 10) {
                re = (x % 10) + re * 10;
                x = x / 10;
            } else return 0;
        }
        return re;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
