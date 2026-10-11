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
    int postIdx=0;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx=postorder.length-1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return solve(postorder,0,inorder.length-1);
    }
    public TreeNode solve(int[] postOrder , int left, int right){
        if(left>right) return null;
        int val = postOrder[postIdx--];
        TreeNode node = new TreeNode(val);

        int mid = map.get(val);

        node.right=solve(postOrder,mid+1,right);

        node.left=solve(postOrder,left,mid-1);

        return node;
    }
}