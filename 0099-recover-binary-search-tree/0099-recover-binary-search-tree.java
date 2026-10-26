class Solution {
    private TreeNode first;
    private TreeNode last;
    private TreeNode mid;
    private TreeNode prev;

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inOrder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = last = mid = prev = null;

        inOrder(root);

        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        } else if (first != null && mid != null) {
            int t = first.val;
            first.val = mid.val;
            mid.val = t;
        }
    }
}