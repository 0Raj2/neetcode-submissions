class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int ind = 0;
        int r = k - 1;
        int l = 0;

        while (r < nums.length) {
            res[ind] = getMaxFromWindow(l, r, nums);
            l++;
            r++;
            ind++;
        }

        return res;
    }

    public int getMaxFromWindow(int l, int r, int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i = l; i<=r; i++){
            max = Math.max(max,nums[i]);
        }

        return max;
    }
}
