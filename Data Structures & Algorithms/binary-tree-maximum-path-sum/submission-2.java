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

    // -1000 <= Node.val <= 1000
    int maxi = -1001;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return maxi;
    }

    public int dfs(TreeNode node)
    {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        maxi = Math.max(maxi, left + right + node.val);

        return Math.max(0, node.val + Math.max(left, right));
    }
}
