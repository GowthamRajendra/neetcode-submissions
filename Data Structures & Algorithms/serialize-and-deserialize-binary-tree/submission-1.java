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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        String out = "";

        while (!queue.isEmpty())
        {
            TreeNode front = queue.poll();

            if (front == null)
            {
                out += "null,";
            }
            else {
                out += front.val + ",";
        
                queue.add(front.left);
                queue.add(front.right);
            }
        }

        return out;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        if (nodes[0].equals("null")) return null;

        int i = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
                
        TreeNode root = new TreeNode(Integer.parseInt(nodes[i])); 

        queue.add(root);
        i++;

        while (!queue.isEmpty())
        {
            TreeNode front = queue.pop();

            if (!nodes[i].equals("null"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i])); 
                front.left = left;
                queue.add(left);
            }
            i++;

            if (!nodes[i].equals("null"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i])); 
                front.right = right;
                queue.add(right);
            }
            i++;
        }

        return root;
    }
}
