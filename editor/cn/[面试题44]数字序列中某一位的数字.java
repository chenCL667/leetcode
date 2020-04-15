//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
//        暴力法，超时
//        StringBuffer res = new StringBuffer();
//        for (int i = 0; ; i++) {
//            res.append(String.valueOf(i));
//            if (res.length() > 1000) {
//                n = n -1000;
//                res = new StringBuffer(res.substring(1000, res.length()));
//            }
//            if (res.length() > n + 1) break;
//        }
//        return (int)(res.toString().charAt(n) - '0');

//        拼凑法
        if (n < 10) return n;
        int high = 1;
        double pow = 9;
        double N = n;
        int rem = 0;
        while (N > 0) {
            if (N - high * pow > 0) {
                N = N - high * pow;
                high++;
                pow = pow * 10;
            } else if (N - high * pow == 0) {
                return 9;
            } else {
                rem = (int)N % high;
                N = N / high + Math.pow(10, high - 1);
                break;
            }
        }
        if (rem == 0) return (int)(N - 1) % 10;
        String data = String.valueOf((int)N);
        return (int) (data.charAt(rem - 1) - '0');

    }
}
//leetcode submit region end(Prohibit modification and deletion)
