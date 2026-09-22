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
    public int maxPathSum(TreeNode root) {
        int[] maxSum= new int[1];
        maxSum[0]=Integer.MIN_VALUE;
        solve(root,maxSum);
        return maxSum[0];
        
    }
    public int solve(TreeNode root,int[] arr){
        if(root == null) return 0;
        int lSum = Math.max(0, solve(root.left, arr));
        int rSum = Math.max(0, solve(root.right, arr));
        arr[0]= Math.max(arr[0],root.val+lSum+rSum);
        return Math.max(lSum,rSum)+root.val;
    }
}