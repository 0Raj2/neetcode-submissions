class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int l = 0;
        int r = 0;
        int sLen = s.length();
        int tLen = t.length();
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;

        Map<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        while (r < sLen) {
            char c = s.charAt(r);
            if (mpp.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(mpp.get(c))) {
                    count++;
                }
            }
            r++;

            while (count == mpp.size()) {
                if (r - l < minLen) {
                    minLen = r - l;
                    startIdx = l;
                }
                char d = s.charAt(l);
                if (mpp.containsKey(d)) {
                    if (window.get(d).equals(mpp.get(d))) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                l++;
            }
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}