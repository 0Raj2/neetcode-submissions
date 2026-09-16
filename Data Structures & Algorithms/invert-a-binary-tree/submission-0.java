class Solution {
    public TreeNode invertTree(TreeNode root) {
        func(root);
        return root;
    }

    private void func(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        func(node.left);
        func(node.right);
    }
}