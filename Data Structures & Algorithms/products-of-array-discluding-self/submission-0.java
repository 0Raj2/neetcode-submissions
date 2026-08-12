class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefArr = new int[n];
        int[] suffArr = new int[n];
        int bag = 1;

        for (int i = 0; i < n; i++) {
            bag = bag * nums[i];
            prefArr[i] = bag;
        }

        bag = 1;
        for (int i = n - 1; i >= 0; i--) {
            bag = bag * nums[i];
            suffArr[i] = bag;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums[i] = suffArr[i + 1];
            } else if (i == n - 1) {
                nums[i] = prefArr[i - 1];
            } else {
                nums[i] = suffArr[i + 1] * prefArr[i - 1];
            }
        }

        return nums;
    }
}
