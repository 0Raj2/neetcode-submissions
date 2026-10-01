class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int count = 0;
        int ans = 0;
        Map<Character, Integer> mpp = new HashMap<>();

        while (r < s.length()) {
            int max = findGreatestFromMap(mpp);
            int value = (r - l + 1) - max;

            if (s.charAt(l) == s.charAt(r)) {
                count = r - l + 1;
                mpp.put(s.charAt(l), mpp.getOrDefault(s.charAt(l), 0) + 1);
                r++;
            } else if (s.charAt(l) != s.charAt(r) && value <= k) {
                mpp.put(s.charAt(l), mpp.getOrDefault(s.charAt(l), 0) + 1);
                r++;
            } else if (s.charAt(l) != s.charAt(r) && value > k) {

                count = r - l + 1;
                mpp.put(s.charAt(l), mpp.getOrDefault(s.charAt(l), 0) - 1);
            }

            ans = Math.max(ans,count);
        }

        return ans;
    }

    public int findGreatestFromMap(Map<Character, Integer> map) {
        if (map.size() == 0) {
            return 0;
        }
        int max = 0;
        int maxInd = 0;

        for (Map.Entry<Character, Integer> mppValue : map.entrySet()) {
            if (max < mppValue.getValue()) {
                max = mppValue.getValue();
                maxInd = mppValue.getKey();
            }
        }

        return maxInd;
    }
}
