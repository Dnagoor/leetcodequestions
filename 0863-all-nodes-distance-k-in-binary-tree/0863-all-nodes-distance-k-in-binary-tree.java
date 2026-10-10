/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null) return new ArrayList<>();

        Map<TreeNode,TreeNode> map = new HashMap<>();
        MakeParents(root,map);
        HashSet<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        vis.add(target);
        int dis=0;
        while(!q.isEmpty()){
            if(dis==k) break;
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode node = q.poll();
                if(node.left!=null && !vis.contains(node.left)){
                    q.offer(node.left);
                    vis.add(node.left);

                }
                // right
                if(node.right!=null && !vis.contains(node.right)){
                    q.offer(node.right);
                    vis.add(node.right);
                }
                // check if parents are visted or na
                // check if node has a parent or na
                if(map.containsKey(node) && !vis.contains(map.get(node))){
                    q.offer(map.get(node));
                    vis.add(map.get(node));
                }
            }
            dis++;
        }
        List<Integer> list= new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
        
    }
    public void MakeParents(TreeNode root, Map<TreeNode,TreeNode> map){
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null) {
                map.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
}