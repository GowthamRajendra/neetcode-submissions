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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            TreeNode right = null;
            int currLen = queue.size();

            for (int i = 0; i < currLen; i++)
            {
                TreeNode node = queue.poll();

                if (node == null) continue; 

                right = node;

                queue.add(node.left);
                queue.add(node.right);
            }

            if (right != null) out.add(right.val);
        }

        return out;
    }
}
