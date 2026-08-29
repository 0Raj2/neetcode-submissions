class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {


        int n = s.length();
        int l = 0;
        int r = 0;
        int res = 0;
        Map<Character,Integer> mpp = new HashMap<>();


        while(r<n){

            char tempR = s.charAt(r);
            mpp.put(tempR,mpp.getOrDefault(tempR,0)+1);

            while(mpp.size() > k){
                char tempL = s.charAt(l);
                mpp.put(tempL,mpp.getOrDefault(tempL,0)-1);
                if(mpp.get(tempL) == 0){
                    mpp.remove(tempL);
                }
                l++;
            }

            if(mpp.size() <= k){
                res =Math.max(findCount(mpp),res);
                 r++;
            }
    
        }


        return res;
        
    }

    public int findCount(Map<Character,Integer> mpp){
        int total = 0;

        for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
            total += entry.getValue();
        }

        return total;
    }
}
