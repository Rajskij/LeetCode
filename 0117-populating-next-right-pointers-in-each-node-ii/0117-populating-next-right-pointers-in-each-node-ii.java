/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            Node prev = new Node();
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                Node current = deque.poll();
                prev.next = current;

                if (current.left != null) deque.offer(current.left);
                if (current.right != null) deque.offer(current.right);

                prev = current;
            }
        }

        return root;
    }
}