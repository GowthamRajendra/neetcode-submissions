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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);

        TreeNode lca = root;

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();

            if (p.val < node.val && q.val < node.val)
            {
                queue.add(node.left);
            }
            else if (p.val > node.val && q.val > node.val)
            {
                queue.add(node.right);
            } else {
                lca = node;
            }
        }

        return lca;
    }
}
