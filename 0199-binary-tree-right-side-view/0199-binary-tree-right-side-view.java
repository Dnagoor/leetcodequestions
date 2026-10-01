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
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        solve(root,list,0);
        return list;
    }
    public void solve(TreeNode root , List<Integer> list,int lev){
        if(root==null) return;
        if(list.size()==lev){
            list.add(root.val);
        }
        solve(root.right,list,lev+1);
        solve(root.left,list,lev+1);

        
    }

}