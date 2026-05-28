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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Stack<Pair<TreeNode, Integer>> myStack = new Stack<>();
        
        myStack.push(new Pair<TreeNode, Integer>(root, 1));

        int maxD = 0;

        while (!myStack.isEmpty())
        {
            Pair<TreeNode, Integer> top = myStack.pop();

            maxD = Math.max(maxD, top.getValue());

            if (top.getKey().right != null) {
                myStack.push(new Pair<TreeNode, Integer>(top.getKey().right, top.getValue() + 1));
            }
            if (top.getKey().left != null) {
                myStack.push(new Pair<TreeNode, Integer>(top.getKey().left, top.getValue() + 1));
            }
        }

        return maxD;
    }
}
