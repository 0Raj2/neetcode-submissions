class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>(); 
        List<Integer> bag = new ArrayList<>();
        powerSetHelper(bag, nums, 0);
        return res;
    }

    public void powerSetHelper(List<Integer> bag, int[] nums, int ind) {
    
        if (nums.length == ind) {
            res.add(new ArrayList<>(bag));
            return;
        }

        bag.add(nums[ind]);
        powerSetHelper(bag, nums, ind + 1);

        bag.remove(bag.size() - 1);

        powerSetHelper(bag, nums, ind + 1);
    }
}
