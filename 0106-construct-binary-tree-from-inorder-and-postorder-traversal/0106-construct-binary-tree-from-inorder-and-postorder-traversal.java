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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildSubTree(map, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(Map<Integer, Integer> map, int[] postorder, int root, int left, int right) {
        TreeNode node = new TreeNode(postorder[root]);

        int mid = map.get(postorder[root]);

        if (mid < right) {
            node.right = buildSubTree(map, postorder, root - 1, mid + 1, right);
        }


        if (mid > left) {
            node.left = buildSubTree(map, postorder, root - (right - mid) - 1, left, mid - 1);
        }

        return node;
    }
}