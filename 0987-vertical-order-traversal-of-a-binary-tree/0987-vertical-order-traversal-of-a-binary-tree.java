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
    TreeNode node;
    int col;
    int row;
    tuple(TreeNode node , int col, int row){
        this.node= node;
        this.col=col;
        this.row=row;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        // creating a MONSTER data structure
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple t = q.poll();
            TreeNode node = t.node;
            int col = t.col;
            int row = t.row;

            // check if column is present in map
            if(!map.containsKey(col)){ // because col is the key for both row and the queue
                map.put(col,new TreeMap<>());
            }
            // check if the row for particular col is present
            if(!map.get(col).containsKey(row)){
                map.get(col).put(row,new PriorityQueue<>());
            }
            // if both present then update the map
            map.get(col).get(row).offer(node.val);
            // if left present
            if(node.left!=null) q.offer(new tuple(node.left,col-1,row+1));
            if(node.right!=null) q.offer(new tuple(node.right,col+1,row+1));
        }
        // collect all the elements
        for(TreeMap<Integer,PriorityQueue<Integer>> eachCol : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> val : eachCol.values()){
                while(!val.isEmpty()){
                    list.add(val.poll());
                }
            }
            ans.add(list);
        }
        return ans;
        
    }
    
}