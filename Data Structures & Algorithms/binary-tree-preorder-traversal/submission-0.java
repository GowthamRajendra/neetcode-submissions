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
    List<Integer> preorder;

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder = new ArrayList<>();

        traverse(root);
        return preorder;
    }

    private void traverse(TreeNode curr)
    {
        if (curr == null) return;

        preorder.add(curr.val);
        traverse(curr.left);
        traverse(curr.right);
    }
}