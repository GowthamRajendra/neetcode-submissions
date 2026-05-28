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
    public boolean isValidBST(TreeNode root) {
        // -1000 <= Node.val <= 1000
        return isValid(root, -1001, 1001);
    }

    private boolean isValid(TreeNode node, int left, int right)
    {
        if (node == null) return true;

        if (node.val <= left || node.val >= right) return false;

        return isValid(node.left, left, node.val) && isValid(node.right, node.val, right);
    }
}
