/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val;
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        dfs(root, currentPath, allPaths);
        
        int totalSum = 0;
        for (List<Integer> path : allPaths) {
            int num = 0;
            for (int digit : path) {
                num = num * 10 + digit;
            }
            totalSum += num;
        }
        
        return totalSum;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> allPaths) {
        if (node == null) {
            return; 
        }

        path.add(node.val); 
        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(path)); 
        } else {
            dfs(node.left, path, allPaths); 
            dfs(node.right, path, allPaths);
        }
        path.remove(path.size() - 1); 
        
    }
}