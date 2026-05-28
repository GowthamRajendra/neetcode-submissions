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

    HashMap<Integer, Integer> order = new HashMap<>(); 
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++)
        {
            order.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int l,int r)
    {
        if (l > r) return null;

        TreeNode node = new TreeNode(preorder[index]); 
        index++;

        int mid = order.get(node.val);

        node.left = dfs(preorder, l, mid-1);
        node.right = dfs(preorder, mid+1, r);

        return node;
    }
}
