//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
//        暴力法
//        if (s.length() == 0 || s.length() == 1) return s.length();
//        int max = 0;
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length() - 1; i++) {
//            set.clear();
//            set.add(s.charAt(i));
//            max = Math.max(max, set.size());
//            for (int j = i + 1; j < s.length(); j++) {
//                if (set.contains(s.charAt(j))) {
//                    break;
//                }
//                else {
//                    set.add(s.charAt(j));
//                    max = Math.max(max, set.size());
//                }
//            }
//        }
//        return max;

//        动态规划
        if (s.length() == 0 || s.length() == 1) return s.length();
        int maxLength = 0;
        int dis = 0;
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        map.put(s.charAt(0), 0);
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) dp[i] = dp[i - 1] + 1;
            else {
                dis = i - map.get(s.charAt(i));
                if (dis > dp[i - 1]) dp[i] = dp[i - 1] + 1;
                else dp[i] = dis;
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
