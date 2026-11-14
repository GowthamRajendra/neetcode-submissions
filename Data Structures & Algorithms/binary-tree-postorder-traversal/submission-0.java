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
    List<Integer> postorder;

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder = new ArrayList<>();

        traverse(root);
        return postorder;
    }


    private void traverse(TreeNode curr)
    {
        if (curr == null) return;

        traverse(curr.left);
        traverse(curr.right);
        postorder.add(curr.val);
    }
}