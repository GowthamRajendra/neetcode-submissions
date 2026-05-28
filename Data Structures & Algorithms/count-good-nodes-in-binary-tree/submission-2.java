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
    public int goodNodes(TreeNode root) {

        LinkedList<Pair<TreeNode,Integer>> queue = new LinkedList<>();

        // -100 <= Node.val <= 100
        queue.add(new Pair<TreeNode, Integer>(root, -200));

        int good = 0;

        while (!queue.isEmpty())
        {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode node = curr.getKey();
            int val = curr.getValue();

            if (node == null) continue;

            if (node.val >= val)
            {
                good++;
                val = node.val;
            }

            queue.add(new Pair<TreeNode, Integer> (node.left, val));
            queue.add(new Pair<TreeNode, Integer> (node.right, val));
        }

        return good;
    }
}
