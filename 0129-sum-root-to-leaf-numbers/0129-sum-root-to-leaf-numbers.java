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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int total = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return total;
        }
        
        return sum(node.left, total) + sum(node.right, total);
    }
}