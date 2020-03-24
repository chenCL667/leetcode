//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Example 1: 
//
// 
//Input: 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Follow up: 
//
// Coud you solve it without converting the integer to a string? 
// Related Topics Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
//        借助数组来存储每位的数字，然后遍历判断是否是回文
//        注意负数都不是回文数
//        时间复杂度为O(log10 n)，空间复杂度为O(log10 n)
//        if (x < 0) return false;
//        int[] nums = new int[15];
//        int index = 0;
//        while (x != 0) {
//            nums[index++] = x % 10;
//            x = x / 10;
//        }
//        for (int i = 0; i < index / 2; i++) {
//            if (nums[i] != nums[index - 1 - i])
//                return false;
//        }
//        return true;


        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int re = 0;
        while (x > re) {
            re = x % 10 + re * 10;
            x = x / 10;
        }
        return re == x || re / 10 == x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
