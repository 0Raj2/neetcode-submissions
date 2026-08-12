class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }

        for (Integer i : numsSet) {
            if (!numsSet.contains(i - 1)) {
                int value = i;
                int count = 1;
                while (numsSet.contains(value + 1)) {
                    value++;
                    count++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }
}
