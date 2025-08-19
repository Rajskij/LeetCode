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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // Queue for BFS aproach
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // Flag to indicate direction
        boolean isLeftToRight = true;

        // Iterate through tree, and add level nodes depending on diraction
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(isLeftToRight) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }

                // Add children
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            result.add(list);
            isLeftToRight = !isLeftToRight;
        }

        return result;
    }
}