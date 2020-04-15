//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        if (n <= 0 ) return 0;

        int high = 0;
        int pow = 0;
        int last = 0;
        String data = String.valueOf(n);
        high = data.charAt(0) - '0';
        pow = (int)Math.pow(10, data.length() - 1);
        last = n - pow * high;
        if (high == 1) return countDigitOne(pow - 1) + last + 1 + countDigitOne(last);
        else return pow + high * countDigitOne(pow - 1) + countDigitOne(last);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
