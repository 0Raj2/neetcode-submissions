class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        int max = 0;
        int count = 0;
        int n = s.length()-1;

        Map<Character,Integer> mpp = new HashMap<>();

        while(l<=n && r <= n){

            if(mpp.containsKey(s.charAt(r))){
                l = Math.max(l, mpp.get(s.charAt(r))+1);
            }
            count = r-l+1;
            mpp.put(s.charAt(r),r);
            max = Math.max(max,count);
            r++;

        }

        return max;


        
    }
}
