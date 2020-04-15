//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int mid = 0, begin = 0, end = x;
        long mul = 0;//记得这里需要用long类型，防止溢出
        while (begin <= end) {
            mid = (end - begin) / 2 + begin;//为防止溢出，这里不能写成(begin+end)/2
            mul = (long)mid * mid;//这里的long强制转型不能省略，否则会溢出
            if (mul == x) return mid;
            else if (mul < x) begin = mid + 1;
            else end = mid - 1;
        }
        return end;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
