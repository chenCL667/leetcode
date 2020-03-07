//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //如果链表中只有0或1个元素时，直接返回原样
        if (head == null || head.next == null) return head;

        ListNode fast = null;
        ListNode slow = null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode current = res;


        while (current.next != null && current.next.next != null) {
            fast = current.next.next;
            slow = current.next;

            slow.next = fast.next;
            current.next = fast;
            current.next.next = slow;
            current = current.next.next;
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
