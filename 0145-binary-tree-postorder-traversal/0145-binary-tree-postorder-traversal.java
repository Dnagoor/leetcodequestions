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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp==null){
                    temp=st.pop();
                    list.add(temp.val);
                    while(!st.isEmpty() && st.peek().right==temp){
                        temp=st.pop();
                        list.add(temp.val);
                    }

                }
                else{
                    curr= temp;
                }
            }
        }
        return list;

 


    }
}