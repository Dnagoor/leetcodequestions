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
    public List<Integer> preorderTraversal(TreeNode root) {
        // morris traversal
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left== null){
                list.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode f = curr.left;
                while(f.right!=null && f.right!=curr){
                    f=f.right;
                }
                if(f.right==null){
                    f.right=curr;
                    list.add(curr.val);
                    curr=curr.left;

                }
                else{
                    f.right=null;
                    curr=curr.right;
                }
            }
        }
        return list;
        
    }
}