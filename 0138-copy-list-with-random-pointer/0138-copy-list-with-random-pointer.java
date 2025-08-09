/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Check if head == null
        if (head == null) return null;

        // Create Map that stroes orignal node as key and new copy as value
        Map<Node, Node> map = new HashMap<>();

        Node current = head;
        // Store each node in map
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Reasign next and random pointers for new Nodes
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}