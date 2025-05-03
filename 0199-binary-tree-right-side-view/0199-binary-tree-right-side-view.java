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
// queue -> root 
// put left, right
// on each step we wil itarate though the queue of nodes and 

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            deque.offer(root);
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (i == 0) {
                    list.add(node.val);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
            }
        }

        return list;
    }
}