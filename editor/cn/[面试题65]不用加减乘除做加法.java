//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
        int and = 1;
        int xor = 1;
        while ((and & xor) != 0) {
            and = a & b;
            and = and << 1;
            xor = a ^ b;

            a = and;
            b = xor;
        }
        return and ^ xor;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
