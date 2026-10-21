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
        TreeNode curr = root; // for traversal
        int cnt =0; // for counting the visited nodes
        int ans = -1; // to storing the value at k 
        // inorder traversal using morris traversal
        // inorder traversal gives sorted elem in traversal making 
        // geting the kth elemen is easy
        while(curr!=null){
            if(curr.left==null){
                cnt++;
                if(cnt == k){
                    ans = curr.val;
                }
                curr=curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right = curr;
                    curr=curr.left;
                }
                else{
                    prev.right = null;
                    cnt++;
                    if(cnt==k){
                        ans = curr.val;
                    }
                    curr= curr.right;
                }
            }
        }
        return ans;
        
    }
}