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
    public ListNode partition(ListNode head, int x) {
        // Create 2 nodes
        // Before x node
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        // After x node
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        // Iterate though list 
        while (head != null) {
            if (head.val < x) {
                // add node to before list if it lest then x
                before.next = head;
                before = before.next;
            } else {
                // or add node to after list if node >= x
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // link before and after list
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}