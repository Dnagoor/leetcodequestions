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
 class bst{
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;
    public bst(TreeNode root, boolean isReverse){
        reverse=isReverse;
        pushAll(root);
    }
    public void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse) root=root.right;
            else root=root.left;
        }
    }
    public int next(){
        TreeNode root = st.pop();
        if(reverse) pushAll(root.left);
        else pushAll(root.right);
        return root.val;
    }

 }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;

        bst l = new bst(root,false);
        bst r = new bst(root,true);

        int i = l.next();
        int j = r.next();

        while(i < j){
            if(i + j ==k)return true;
            else if(i+j < k) i=l.next();
            else j = r.next();
        }
        return false;
        
    }
}