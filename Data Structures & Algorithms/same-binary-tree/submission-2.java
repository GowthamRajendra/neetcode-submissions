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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        LinkedList<Pair<TreeNode,TreeNode>> queue = new LinkedList<>();

        queue.add(new Pair<TreeNode, TreeNode> (p, q));

        while (!queue.isEmpty())
        {
            Pair<TreeNode, TreeNode> nodes = queue.poll();
            TreeNode first = nodes.getKey();
            TreeNode second = nodes.getValue();

            if (first == null && second == null) continue;
            if (first == null || second == null) return false;
            if (first.val != second.val) return false;

            queue.add(new Pair<TreeNode, TreeNode> (first.left, second.left));
            queue.add(new Pair<TreeNode, TreeNode> (first.right, second.right));
        }

        return true;
    }
}
