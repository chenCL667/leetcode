//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        存在错误
//        int tmp = 0;//表示进位
//        int sum = 0;
//        ListNode head1 = l1, head2 = l2;
//        while (l1 != null && l2 != null) {
//            sum = l1.val + l2.val + tmp;
//            tmp = sum / 10;
//            l1.val = sum % 10;
//            l2.val = l1.val;
//
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        if (l1 != null) {
//            while (tmp > 0 && l1 != null) {
//                sum = l1.val + tmp;
//                tmp = sum / 10;
//                l1.val = sum % 10;
//                l1 = l1.next;
//            }
//            return head1;
//        }
//
//        if (l2 != null) {
//            while (tmp > 0 && l2 != null) {
//                sum = l2.val + tmp;
//                tmp = sum / 10;
//                l2.val = sum % 10;
//                l2 = l2.next;
//            }
//            return head2;
//        }
//        if (l1 == null && l2 == null && tmp > 0) {
//            Listnode end = new ListNode(tmp);
//        }
//        return head1;

//        申请新空间
        ListNode fakeHead = new ListNode(0);
        ListNode head1 = l1, head2 = l2;
        ListNode current = fakeHead;
        int tmp = 0;
        while (head1 != null && head2 != null) {
            current.next = new ListNode((head1.val + head2.val + tmp) % 10);
            tmp = (head1.val + head2.val + tmp) / 10;
            head1 = head1.next;
            head2 = head2.next;
            current = current.next;
        }

        while (head1 != null) {
            current.next = new ListNode((head1.val + tmp) % 10);
            tmp = (head1.val + tmp) / 10;
            head1 = head1.next;
            current = current.next;
        }

        while (head2 != null) {
            current.next = new ListNode((head2.val + tmp) % 10);
            tmp = (head2.val + tmp) / 10;
            head2 = head2.next;
            current = current.next;
        }

        if (tmp > 0) {
            current.next = new ListNode(tmp);
        }
        return fakeHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
