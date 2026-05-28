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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> out = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            List<Integer> currLvl = new ArrayList<>();

            int currLen = queue.size();

            for (int i = 0; i < currLen; i++)
            {
                TreeNode node = queue.poll();

                if (node == null) continue; 

                currLvl.add(node.val);

                queue.add(node.left);
                queue.add(node.right);
            }

            if (currLvl.size() > 0) out.add(currLvl);
        }

        return out;
    }
}
