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
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, Integer.MAX_VALUE , new int[]{0});
    }
    public TreeNode solve(int[] a , int bound ,int[] i){
        if(i[0]==a.length || a[i[0]] > bound){
            return null;
        }
        TreeNode node = new TreeNode(a[i[0]++]);
        node.left= solve(a,node.val,i);
        node.right= solve(a,bound,i);
        return node;
    }
    
}