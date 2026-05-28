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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            TreeNode front = queue.poll();

            TreeNode left = front.left;
            front.left = front.right;
            front.right = left;

            if (front.left != null) queue.add(front.left);
            if (front.right != null) queue.add(front.right);
        }

        return root;
    }
}
