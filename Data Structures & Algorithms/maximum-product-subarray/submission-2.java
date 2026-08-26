class Solution {
    public int maxProduct(int[] nums) {

        int prefixProduct = 1; 
        
        int suffixProduct = 1;

        int n = nums.length;
        int res = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(prefixProduct == 0){
                prefixProduct = 1;
            }
            if(suffixProduct == 0){
                suffixProduct = 1;
            }

            prefixProduct *= nums[i];
            suffixProduct *= nums[n-i-1];

            res = Math.max(res,Math.max(prefixProduct,suffixProduct));

        }

        return res;
        
    }
}
