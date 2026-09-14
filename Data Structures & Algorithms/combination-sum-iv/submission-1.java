public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, target, memo);
    }

    private int dfs(int[] nums, int total, int[] memo) {
        if (total == 0) {
            return 1;
        }
        if (memo[total] != -1) {
            return memo[total];
        }

        int res = 0;
        for (int num : nums) {
            if (total < num) {
                break;
            }
            res += dfs(nums, total - num, memo);
        }
        return memo[total] = res;
    }
}