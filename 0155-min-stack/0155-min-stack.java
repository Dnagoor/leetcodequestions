class MinStack {
    Stack<Integer> st;
    Stack<Integer> minstack;

    public MinStack() {
        st = new Stack<>();
        minstack= new Stack<>();

        
    }
    
    public void push(int value) {
        st.push(value);

        if(minstack.isEmpty()){
            minstack.push(value);
        }
        else{
            minstack.push(Math.min(value,minstack.peek()));
        }
        
    }
    
    public void pop() {
        st.pop();
        minstack.pop();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return minstack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */