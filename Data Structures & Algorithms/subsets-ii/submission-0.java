class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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

        while (ind + 1 < nums.length && nums[ind] == nums[ind + 1]) {
            ind++;
        }
        powerSetHelper(bag, nums, ind + 1);
    }
}
