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

    public void dfs(TreeNode node)
    {
        if (node == null) return ;

        int left = dfs2(node.left);
        int right = dfs2(node.right);

        maxi = Math.max(maxi, left + right + node.val);

        dfs(node.left);
        dfs(node.right);
    }

    public int dfs2(TreeNode node)
    {
        if (node == null) return 0;

        int left = dfs2(node.left);
        int right = dfs2(node.right);

        return Math.max(0, Math.max(left + node.val, right + node.val));
    }
}
