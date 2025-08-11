/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // Introduce 2 nodes fast and slow
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast node n times
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Then move both nodes until fast reaches end of list
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove n node from list
        slow.next = slow.next.next;

        return dummy.next;
    }
}