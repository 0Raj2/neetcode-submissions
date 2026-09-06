class Solution {
    public int maxProduct(int[] nums) {
        int prefixSubArray = 1;
        int suffixSubArray = 1;

        int res = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (prefixSubArray == 0) {
                prefixSubArray = 1;
            }

            if (suffixSubArray == 0) {
                suffixSubArray = 1;
            }

            prefixSubArray *= nums[i];
            suffixSubArray *= nums[n - i - 1];

            res = Math.max(res, Math.max(prefixSubArray, suffixSubArray));
        }

        return res;
    }
}
