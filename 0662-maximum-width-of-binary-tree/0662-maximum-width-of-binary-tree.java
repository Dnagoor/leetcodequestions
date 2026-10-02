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
class tuple{
    int idx;    
    TreeNode node;
    tuple(int idx, TreeNode node){
        this.idx = idx;
        this.node= node;

    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<tuple> q = new LinkedList<>();
        int max=0;
        q.offer(new tuple(0,root));

        while(!q.isEmpty()){
            int s= q.size();
            int last=0 , first=0, minidx=q.peek().idx;

            for(int i=0;i<s;i++){
                tuple curr = q.poll();
                TreeNode node =curr.node;
                int currIdx= curr.idx;
                currIdx-=minidx;
                if(i==0) first=currIdx;
                if(i==s-1) last=currIdx;

                // add left child 
                if(node.left!=null) q.offer(new tuple(2*currIdx+1,node.left));
                if(node.right!=null) q.offer(new tuple(2*currIdx+2,node.right));

            }
            max= Math.max(max,last-first+1);

        }
        return max;

        
    }
}