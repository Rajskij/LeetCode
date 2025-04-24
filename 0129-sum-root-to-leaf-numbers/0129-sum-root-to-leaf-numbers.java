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
        if (root == null) {
            return 0;
        }

        return sum(root, 0);
    }

    private int sum(TreeNode node, int sum) {
        int total = sum * 10 + node.val;
        int left = 0;
        int right = 0;
        if (node.left == null && node.right == null) {
            return total;
        }
        if (node.left != null) {
            left = sum(node.left, total);
        }
        if (node.right != null) {
            right = sum(node.right, total);
        }
        
        return left + right;
    }
}