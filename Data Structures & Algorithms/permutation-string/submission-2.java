class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1ARR = new int[26];
        int[] s2ARR = new int[26];
        int init = 'a' + 0;

        for (int i = 0; i < s1.length(); i++) {
            int temp = s1.charAt(i) + 0;
            s1ARR[temp - init] = s1ARR[temp - init] + 1;
        }

        int l = 0;
        int r = s1.length() - 1;

        for (int i = 0; i < s1.length(); i++) {
            
            int temp = s2.charAt(i) + 0;
            s2ARR[temp - init] = s2ARR[temp - init] + 1;
        }



        if (Arrays.equals(s1ARR, s2ARR)) {
            return true;
        } else {
            while (l < s2.length()-1 && r < s2.length()-1) {
                
                if (Arrays.equals(s1ARR, s2ARR)) {
                    return true;
                } else {
                    
                    s2ARR[(s2.charAt(l) + 0) - init] = s2ARR[(s2.charAt(l) + 0 )- init] - 1;
                   
                    s2ARR[(s2.charAt(r+1) + 0) - init] = s2ARR[(s2.charAt(r+1) + 0) - init] + 1;
                    l++;
                    r++;
                }

                System.out.println(Arrays.toString(s1ARR));
                System.out.println(Arrays.toString(s2ARR));

            }
        }

        // System.out.println(Arrays.toString(s2ARR));

        return Arrays.equals(s1ARR, s2ARR);
    }
}
