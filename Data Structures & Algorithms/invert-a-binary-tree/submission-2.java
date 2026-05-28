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

        Stack<TreeNode> myStack = new Stack<>();
        
        myStack.push(root);

        while (!myStack.isEmpty())
        {
            TreeNode top = myStack.pop();

            TreeNode left = top.left;
            top.left = top.right;
            top.right = left;

            if (top.right != null) myStack.push(top.right);
            if (top.left != null) myStack.push(top.left);
        }

        return root;
    }
}
