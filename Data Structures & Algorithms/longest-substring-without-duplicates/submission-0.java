class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> arrSet = new HashSet<>();

        int max = 0;
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if(arrSet.contains(s.charAt(i))){
                max = Math.max(count,max);
                count = 1;
                
            }else{
                count++; 
                arrSet.add(s.charAt(i));
            }

        }

        return max;
        
    }
}
