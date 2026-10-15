/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node==null){
                sb.append("n,");
                continue;
            }
            sb.append(node.val).append(",");

            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if(s.isEmpty()) return null;

        String[] val = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx=1;

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!val[idx].equals("n")){
                node.left=new TreeNode(Integer.parseInt(val[idx]));
                q.offer(node.left);
            }
            idx++;
            // do for right
            if(!val[idx].equals("n")){
                node.right= new TreeNode(Integer.parseInt(val[idx]));
                q.offer(node.right);
                
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));