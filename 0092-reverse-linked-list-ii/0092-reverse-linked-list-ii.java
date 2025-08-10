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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        
        // Create dummy node to find left node 
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1. Move previos nod before left
        ListNode prev = dummy; // 1
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // 2. Reverse sublist
        ListNode curr = prev.next; // 2
        for (int i = 0; i < right - left; i++) { // 1 < 2
            ListNode next = curr.next; // 3, 4

            curr.next = next.next; // 2 -> 4, 2 -> 5
            next.next = prev.next; // 3 -> 2, 4 -> 3
            prev.next = next; // 1 -> 3, 1 -> 4
        }
        
        return dummy.next;
    }
}