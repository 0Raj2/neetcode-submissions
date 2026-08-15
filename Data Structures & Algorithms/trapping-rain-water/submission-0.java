class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] maxArrLeft = new int[n];
        int[] maxArrRight = new int[n];
        int[] minOfArr = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            maxArrLeft[i] = max;
            max = Math.max(height[i], max);
        }

        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxArrRight[i] = max;
            max = Math.max(height[i], max);
        }

        for (int i = n - 1; i >= 0; i--) {
            minOfArr[i] = Math.min(maxArrLeft[i], maxArrRight[i]);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (minOfArr[i] - height[i] > 0) {
                count += minOfArr[i] - height[i];
            }
        }

        return count;
    }
}
