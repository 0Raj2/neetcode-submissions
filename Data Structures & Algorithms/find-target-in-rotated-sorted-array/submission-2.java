class Solution {
    public int search(int[] nums, int target) {


        int low = 0;
        int hi = nums.length-1;

        

        while(low<=hi){
            int mid = low+(hi-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[low] == nums[mid] && nums[mid] == nums[hi]) {
                low = low + 1;
                hi = hi - 1;
                continue;
            }

            if(nums[mid] <= nums[hi]){
                if(target < nums[hi]){
                    hi = mid-1;
                    continue;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid] > nums[low]){
                if(target < nums[low]){
                    low = mid+1;
                    continue;
                }else{
                    hi = mid-1;
                }
            }
        }

        return -1;
        
    }
}
