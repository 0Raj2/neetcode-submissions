class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1ARR = new int[26];
        int[] s2ARR = new int[26];
        int init = 'a' + 0;

        for (int i = 0; i < s1.length(); i++) {
            int temp = s1.charAt(i);
            s1ARR[temp - init] = s1ARR[temp - init] + 1;
        }

        int l = 0;
        int r = s1.length() - 1;

        for (int i = 0; i < s1.length(); i++) {
            int temp = s2.charAt(i);
            s2ARR[temp - init] = s2ARR[temp - init] + 1;
        }

        while (l < s2.length() - s1.length() + 1) {
            if (Arrays.equals(s1ARR, s2ARR)) {
                return true;
            }
            if (r + 1 < s2.length()) {
                s2ARR[s2.charAt(l) - init]--;
                s2ARR[s2.charAt(r + 1) - init]++;
                l++;
                r++;
            } else {
                break;

            }

        }
        return Arrays.equals(s1ARR, s2ARR);
        }
}
