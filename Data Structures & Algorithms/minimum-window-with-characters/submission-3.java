class Solution {
    public String minWindow(String s, String t) {
        int sn = s.length();
        int tn = t.length();

        if (sn < tn) {
            return "";
        }

        Map<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < tn; i++) {
            char temp = t.charAt(i);
            mpp.put(temp, mpp.getOrDefault(temp, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int r = 0;
        int l = 0;
        int count = 0;
        int res = Integer.MAX_VALUE;
        int minl = -1;
        int minr = -1;

        while (r < sn) {
            char valr = s.charAt(r);

            if (mpp.containsKey(valr)) {
                 mpp.put(valr, mpp.getOrDefault(valr, 0) - 1);
                if (mpp.get(valr) == 0) {
                    count++;
                }
            }

            while (count == tn) {

                if(res>(r - l + 1)){
                    res = (r - l + 1);
                    minl = l;
                    minr = r;
                }
                char val = s.charAt(l);
                if (mpp.containsKey(val)) {
                    mpp.put(val, mpp.getOrDefault(val, 0) + 1);
                    count--;
                } else {
                    window.put(val, window.getOrDefault(val, 0) - 1);
                }
                l++;
            }
            // res = Math.min(res,(r-l+1));
            window.put(valr, window.getOrDefault(valr, 0) + 1);
            r++;
        }

        res = res+minl;

        return s.substring(minl,res);
    }
}
