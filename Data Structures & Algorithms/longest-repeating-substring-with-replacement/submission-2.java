class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;

        int ans = 0;
        int maxFreq = 0;
        Map<Character, Integer> mpp = new HashMap<>();

        while (r < s.length()) {
            char rightChar = s.charAt(r);
            mpp.put(rightChar, mpp.getOrDefault(rightChar, 0) + 1);
            maxFreq = Math.max(maxFreq, mpp.get(rightChar));

            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
