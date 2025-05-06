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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int max = Integer.MIN_VALUE;
        int result = 0;

        for (int level = 1; !deque.isEmpty(); level++) {
            int size = deque.size();
            int current = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                current += node.val;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            if (current > max) {
                max = current;
                result = level;
            }
        }

        return result;
    }
}