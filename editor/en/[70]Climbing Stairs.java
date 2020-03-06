//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// Note: Given n will be a positive integer. 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        // // 递归求解
        // if (n == 1) return 1;
        // if (n == 2) return 2;
        // return climbStairs(n - 1) + climbStairs(n - 2);

        // 非递归求解
        if (n == 1) return 1;
        if (n == 2) return 2;
        int first = 1, second = 2;
        for (int i = 3; i < n + 1; i++){
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
