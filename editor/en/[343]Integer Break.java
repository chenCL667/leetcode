//Given a positive integer n, break it into the sum of at least two positive int
//egers and maximize the product of those integers. Return the maximum product you
// can get. 
//
// Example 1: 
//
// 
// 
//Input: 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1. 
//
// 
// Example 2: 
//
// 
//Input: 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36. 
//
// Note: You may assume that n is not less than 2 and not larger than 58. 
// 
// Related Topics Math Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i < n + 1; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                max = Math.max(max, product);
            }
            products[i] = max;
        }
        return products[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
