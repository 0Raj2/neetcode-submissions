class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int res = 0;
        int prev = nums[0];

        for(int i=0; i<nums.length; i++){
            if(count == 0){
                prev = nums[i];
                count = 1;
            }else if(nums[i] == prev){
                count++;
            }else if(nums[i] != prev){
                count--;
            }
            
            //res = Math.max(res,count);
        }

        return prev;
        
    }
}