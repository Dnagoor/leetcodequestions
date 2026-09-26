class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int flag = 0; // 0 -> left to right

        while(!q.isEmpty()) {

            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                temp.add(node.val);

                if(node.left != null)
                    q.offer(node.left);

                if(node.right != null)
                    q.offer(node.right);
            }

            // 🔥 AFTER processing the entire level
            if(flag == 0) {
                list.add(temp);
                flag = 1;
            }
            else {
                Collections.reverse(temp);
                list.add(temp);
                flag = 0;
            }
        }

        return list;
    }
}