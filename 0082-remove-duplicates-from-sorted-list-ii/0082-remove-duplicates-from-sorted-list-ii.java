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
    public ListNode deleteDuplicates(ListNode head) {
        // Create dummy node for handeling case like duplicates from the start
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // iterate through list 
        while (head != null) {
            // if current node has duplicates move to the next element
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                // if no duplicates just move forwrad
                prev = prev.next;
            }
            // Move head forward
            head = head.next;
        }

        return dummy.next;
    }
}