/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public void flatten(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.push(root);
        }
        
        while (!deque.isEmpty()) {
            TreeNode current = deque.pop();

            if (current.right != null) {
                deque.push(current.right);
            }
            if (current.left != null) {
                deque.push(current.left);
            }
            if (!deque.isEmpty()) {
                current.right = deque.peek();
            }
            current.left = null;
        }
    }
}