class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        Map<Character, Character> mpp = new HashMap<>();

        mpp.put(')', '(');
        mpp.put('}', '{');
        mpp.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (mpp.containsKey(s.charAt(i))) {
                // System.out.println(!(stk.search(mpp.get(s.charAt(i))) == -1));

                if (!(stk.search(mpp.get(s.charAt(i))) == -1)
                    && mpp.get(s.charAt(i)) == stk.peek()) {
                    stk.pop();
                } else {
                    stk.push(s.charAt(i));
                }

            } else {
                stk.push(s.charAt(i));
            }
        }

        return stk.empty();
    }
}
