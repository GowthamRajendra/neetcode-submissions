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
    List<Integer> inorder;

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder = new ArrayList<>();

        traverse(root);
        return inorder;
    }

    private void traverse(TreeNode curr)
    {
        if (curr == null) return;

        traverse(curr.left);
        inorder.add(curr.val);
        traverse(curr.right);
    }
}