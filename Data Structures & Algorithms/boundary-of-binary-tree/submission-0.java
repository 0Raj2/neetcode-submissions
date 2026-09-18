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
    List<Integer> res = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
            return res;

        if (!isLeaf(root)) {
            res.add(root.val);
        }

        getLeftNodes(root.left);

        getLeafNodes(root);

        getRightNodes(root.right);

        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void getLeafNodes(TreeNode root) {
        if (root == null)
            return;

        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }

        getLeafNodes(root.left);
        getLeafNodes(root.right);
    }

    public void getLeftNodes(TreeNode node) {
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }
            node = (node.left != null) ? node.left : node.right;
        }
    }

    public void getRightNodes(TreeNode node) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                temp.add(node.val);
            }
            node = (node.right != null) ? node.right : node.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
}
