class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> arrSet = new HashSet<>();

        int max = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // System.out.println(arrSet.contains(s.charAt(i)));
            if (arrSet.contains(s.charAt(i))) {
                max = Math.max(count, max);
                count = 1;

            } else {
                count++;
                max = Math.max(count, max);
                arrSet.add(s.charAt(i));
                //  System.out.println(count);
            }
        }

        return max;
    }
}
