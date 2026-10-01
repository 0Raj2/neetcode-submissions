class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Queue<Integer> wind = new ArrayDeque();
        int ind = 1;
        int r = k - 1;
        int l = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            wind.add(nums[i]);
            max = Math.max(max, nums[i]);
        }

        res[0] = max;

        for (int i = k; i < nums.length; i++) {
            wind.poll();
            wind.add(nums[i]);
            getMaxFromWindow(ind, wind, res);
            ind++;
        }

        return res;
    }

    public void getMaxFromWindow(int ind, Queue<Integer> wind, int[] res) {
        int max = Integer.MIN_VALUE;
        for (Iterator i = wind.iterator(); i.hasNext();) {
            max = Math.max(max, (int) i.next());
        }

        res[ind] = max;
    }
}
