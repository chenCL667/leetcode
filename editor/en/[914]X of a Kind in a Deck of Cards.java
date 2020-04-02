//In a deck of cards, each card has an integer written on it. 
//
// Return true if and only if you can choose X >= 2 such that it is possible to 
//split the entire deck into 1 or more groups of cards, where: 
//
// 
// Each group has exactly X cards. 
// All the cards in each group have the same integer. 
// 
//
// 
// Example 1: 
//
// 
//Input: deck = [1,2,3,4,4,3,2,1]
//Output: true
//Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
// 
//
// Example 2: 
//
// 
//Input: deck = [1,1,1,2,2,2,3,3]
//Output: false´
//Explanation: No possible partition.
// 
//
// Example 3: 
//
// 
//Input: deck = [1]
//Output: false
//Explanation: No possible partition.
// 
//
// Example 4: 
//
// 
//Input: deck = [1,1]
//Output: true
//Explanation: Possible partition [1,1].
// 
//
// Example 5: 
//
// 
//Input: deck = [1,1,2,2,2,2]
//Output: true
//Explanation: Possible partition [1,1],[2,2],[2,2].
// 
//
// 
// Constraints: 
//
// 
// 1 <= deck.length <= 10^4 
// 0 <= deck[i] < 10^4 
// 
// Related Topics Array Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            if (map.containsKey(deck[i])) map.put(deck[i], map.get(deck[i]) + 1);
            else map.put(deck[i], 1);
        }
        int res = map.get(deck[0]);
        for (int value : map.values()) {
            res = gcd(res, value);
        }
        return res >= 2;
    }

    private int gcd(int a, int b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
