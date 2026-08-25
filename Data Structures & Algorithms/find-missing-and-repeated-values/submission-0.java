class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;

        int[] nums = new int[n*n];
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                nums[count] = grid[i][j];
                count++;
            }
        }

        return findMissingRepeatingNumbers(nums);
        
    }

    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length;
        long sn = (n*(n+1))/2;

        long s2n = (n*(n+1)*((2*n)+1))/6;

        long s = 0;
        long s2 = 0;

        for(int i = 0; i<n; i++){
            s += nums[i];
        }

        for(int i = 0; i<n; i++){
            s2 += (long)nums[i]*(long)nums[i];
        }

        long val1 = s-sn;
        long val2 = s2-s2n;

        val2 = val2/val1;

        long x = (val1+val2)/2;
        long y = x - val1;

        return new int[]{(int)x,(int)y};

    }
}