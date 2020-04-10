//给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。 
//
// 示例 1: 
//
// 
//输入: S = "loveleetcode", C = 'e'
//输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
// 
//
// 说明: 
//
// 
// 字符串 S 的长度范围为 [1, 10000]。 
// C 是一个单字符，且保证是字符串 S 里的字符。 
// S 和 C 中的所有字母均为小写字母。 
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int indexOfChar = -1;
//        从左往右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                indexOfChar = i;
                left[i] = 0;
            } else if (indexOfChar == -1) {
                left[i] = 0;
            } else {
                left[i] = i - indexOfChar;
            }
        }

        indexOfChar = -1;
//        从右往左
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == c) {
                indexOfChar = i;
                right[i] = 0;
            } else if (indexOfChar == -1) {
                right[i] = 0;
            } else {
                right[i] = indexOfChar - i;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (left[i] == 0 || right[i] == 0) left[i] = Math.max(left[i], right[i]);
            else left[i] = Math.min(left[i], right[i]);
        }
        return left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
