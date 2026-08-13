class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> mpp = new HashMap<>();
        
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            
            int moreNeeded = target - num;

            if (mpp.containsKey(moreNeeded)) {

                return new int[]{mpp.get(moreNeeded)+1, i+1};
            }
            mpp.put(nums[i], i);
        }

        return new int[]{-1, -1};
        
    }
}
