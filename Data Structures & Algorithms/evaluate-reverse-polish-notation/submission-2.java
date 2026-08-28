class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> myStack = new Stack<>();

        for(int i = 0; i<tokens.length; i++){
            if(tokens[i].equals("+")){
                int val = myStack.pop()+myStack.pop();
                myStack.push(val);

            }else if(tokens[i].equals("-")){
                int a = myStack.pop();
                int b = myStack.pop();
                int val = b-a;
                myStack.push(val);

            }else if(tokens[i].equals("*")){
                int val = myStack.pop()*myStack.pop();
                myStack.push(val);

            }else if(tokens[i].equals("/")){
                int a = myStack.pop();
                int b = myStack.pop();
                int val = b/a;
                myStack.push(val);
            }else{
                myStack.push(Integer.parseInt(tokens[i]));
            }
        }

        return myStack.pop();
        
    }
}
