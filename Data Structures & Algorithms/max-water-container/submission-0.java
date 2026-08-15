class Solution {
    public int maxArea(int[] heights) {

        int max = 0;
        int l = 0;
        int r = heights.length-1;

        while(l<=r){
            int len = r-l;
            int value = Math.min(heights[l],heights[r])*len;
            max = Math.max(max,value);

            //System.out.println(value);

            if(heights[l]<= heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return max;
        
    }
}
