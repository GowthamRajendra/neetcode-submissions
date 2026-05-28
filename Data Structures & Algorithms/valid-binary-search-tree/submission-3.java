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

class BFSNode {
    public TreeNode node;
    public int left;
    public int right;

    public BFSNode(TreeNode node, int left, int right)
    {
        this.node = node;
        this.left = left;
        this.right = right;
    } 
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)  return true;

        LinkedList<BFSNode> queue = new LinkedList<>();

        // -1000 <= Node.val <= 1000
        queue.add(new BFSNode(root, -1001, 1001));

        while (!queue.isEmpty())
        {
            BFSNode bfsnode = queue.poll();
            TreeNode node = bfsnode.node;
            int left = bfsnode.left;
            int right = bfsnode.right;

            if (node == null) continue;

            if (node.val <= left || node.val >= right) return false;
            
            queue.add(new BFSNode (node.left, left, node.val));
            queue.add(new BFSNode (node.right, node.val, right)); 
        }

        return true;
    }
}
