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

    public List<String> encoded = new ArrayList<String>();
    private int i = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsEncode(root);

        System.out.println(String.join(",", encoded));
        return String.join(",", encoded);
    }

    public void dfsEncode(TreeNode node)
    {
        if (node == null) 
        {
            encoded.add("null");
            return;
        }

        encoded.add(Integer.toString(node.val));

        dfsEncode(node.left);
        dfsEncode(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        return dfsDecode(nodes);
    }

    public TreeNode dfsDecode(String[] nodes)
    {
        if (nodes[i].equals("null")) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));

        i++;
        node.left = dfsDecode(nodes);
        node.right = dfsDecode(nodes);

        return node;
    }
}
