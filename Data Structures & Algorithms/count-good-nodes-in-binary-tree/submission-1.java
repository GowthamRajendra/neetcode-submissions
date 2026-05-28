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

    List<Integer> out = new ArrayList<>();

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);

        return out.size();
    }

    private void dfs(TreeNode node, int val)
    {
        if (node == null)  return ;

        if (node.val >= val)
        {
            val = node.val;
            out.add(node.val);
        }

        dfs(node.left, val);
        dfs(node.right, val);
    }
}
