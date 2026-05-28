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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> myStack = new Stack<>();
        
        myStack.push(root);

        TreeNode curr = root;

        int c = 1;

        while (!myStack.isEmpty() || curr != null)
        {
            while(curr != null)
            {
                myStack.push(curr);
                curr = curr.left;
            }

            curr = myStack.pop();
            
            if (c == k) return curr.val;
            c++;

            curr = curr.right;
        }


        return root.val;
    }
}
