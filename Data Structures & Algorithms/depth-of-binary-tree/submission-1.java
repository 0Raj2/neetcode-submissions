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
    int max = 0;
    public int maxDepth(TreeNode root) {
        maxDepthHelper(root, 1);

        return max;
    }

    private void maxDepthHelper(TreeNode root, int bag) {
        if (root == null) {
            return;
        }

        max = Math.max(bag, max);
        maxDepthHelper(root.left, bag + 1);
        maxDepthHelper(root.right, bag + 1);
        return;
    }
}