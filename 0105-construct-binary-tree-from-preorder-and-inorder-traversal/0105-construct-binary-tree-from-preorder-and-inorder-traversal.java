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
    int preIdx=0;
    Map<Integer,Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1); 
    }
    public TreeNode build(int[] pre,int left,int right){
        if(left > right) return null;
        int rootVal=pre[preIdx++];
        TreeNode node = new TreeNode(rootVal);

        // in pre -> starting is root but inOrder mid is root find the mid in inMap
        int mid = inMap.get(rootVal);

        // connect the left part which is starting to mid-1
        node.left= build(pre,left,mid-1);
        // do same for right
        node.right=build(pre,mid+1,right);

        return node;
    }
}