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
    private HashMap<TreeNode, Integer> memo;
    
    public int rob(TreeNode root) {
        memo = new HashMap<>();
        memo.put(null, 0);

        return dfs(root);
    }

    private int dfs(TreeNode node)
    {
        if (memo.containsKey(node)) return memo.get(node);

        int money = node.val;

        if (node.left != null)
        {
            money += dfs(node.left.left) + dfs(node.left.right);
        }

        if (node.right != null)
        {
            money += dfs(node.right.left) + dfs(node.right.right);
        }

        money = Math.max(money, dfs(node.left) + dfs(node.right));
        memo.put(node, money);

        return money;
    }
}