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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val < val && curr.right == null) {
                TreeNode temp = new TreeNode(val);
                curr.right = temp;
                break;
            } else if (curr.val > val && curr.left == null) {
                TreeNode temp = new TreeNode(val);
                curr.left = temp;
                break;
            } else if (curr.val < val) {
                curr = curr.right;
            } else if (curr.val > val) {
                curr = curr.left;
            }
        }

        return root;
    }
}