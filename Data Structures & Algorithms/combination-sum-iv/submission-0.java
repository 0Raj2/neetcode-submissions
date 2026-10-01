public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        return dfs(nums, target);
    }

    private int dfs(int[] nums, int total) {
        if (total == 0) {
            return 1;
        }

        int res = 0;
        for (int num : nums) {
            if (total < num) {
                break;
            }
            res += dfs(nums, total - num);
        }
        return res;
    }
}