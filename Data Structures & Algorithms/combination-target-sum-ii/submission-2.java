class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //your code goes here
        res = new ArrayList();

        List<Integer> bag = new ArrayList();
        int ind = 0;
        Arrays.sort(candidates);
        combHelper(candidates,target,bag,ind);
       
        return res;
    }

    public void combHelper(int[] nums,int target,List<Integer> bag,int ind){

        if(target == 0){
            res.add(new ArrayList(bag));
            return;
        }

        if( target < 0 ||ind >= nums.length ){
            return;
        }

        bag.add(nums[ind]);
        combHelper(nums,target-nums[ind],bag,ind+1);
        bag.remove(bag.size()-1);
        while(ind + 1 < nums.length && nums[ind] == nums[ind + 1]) {
            ind++;
        }
        combHelper(nums,target,bag,ind+1);

    }
}
