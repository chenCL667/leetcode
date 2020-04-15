//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        Map<Character, Integer> map = new HashMap<>();
        char res = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1){
                res = s.charAt(i);
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
