class MinStack {

    private Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new int[]{val, val});
            return;
        }

        int mini = Math.min(getMin(), val);

        st.push(new int[]{val, mini});
        
    }
    
    public void pop() {

         st.pop();
        
    }
    
    public int top() {
        return st.peek()[0];
        
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
