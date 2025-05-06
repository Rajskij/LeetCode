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
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int result = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            int currentSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                currentSum += node.val;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                result = level;
            }
            level++;
        }

        return result;
    }
}