class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        // Morris Traversal
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode f = curr.left;

                while (f.right != null && f.right != curr) {
                    f = f.right;
                }

                if (f.right == null) {
                    f.right = curr;
                    list.add(curr.val);
                    curr = curr.left;
                }
                else {
                    f.right = null;
                    curr = curr.right;
                }
            }
        }

        return list;
    }
}