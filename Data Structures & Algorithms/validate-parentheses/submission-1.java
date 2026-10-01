class Solution {
    public boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();

        Map<Character,Character> mpp = new HashMap<>();

        mpp.put(')','(');
        mpp.put('}','{');
        mpp.put(']','[');

        for(int i = 0; i<s.length(); i++){
            if(mpp.containsKey(s.charAt(i))){

                if(mpp.get(s.charAt(i)) == stk.peek()){
                    stk.pop();
                }

            }else{
                stk.push(s.charAt(i));
            }
        }

        return stk.empty();

        
    }
}
