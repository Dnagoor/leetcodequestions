class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> prices;

    public StockSpanner() {
        st=new Stack<>();
        prices = new ArrayList<>();
        
    }
    
    public int next(int price) {
        prices.add(price);
        int i = prices.size()-1;
        while(!st.isEmpty() && prices.get(st.peek())<=prices.get(i)){
            st.pop();

        }
        int span;

        if(st.isEmpty()){
            span=i+1;

        }
        else{
            span = i-st.peek();
        }
        st.push(i);
        
        return span;
    }
    

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */