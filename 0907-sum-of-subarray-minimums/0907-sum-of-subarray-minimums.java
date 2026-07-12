class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;
        long ans=0;

        int[] pse = pse(arr);
        int[] nse = nse(arr);
        

        for(int i = 0 ; i<n; i++){
            long left =i-pse[i];
            long right = nse[i]-i;

            ans= (ans+(left*right*arr[i])%mod)% mod;
            
        }
        return (int)ans;
        
    }
    private int[] nse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;
            }
            else ans[i]=st.peek();
            st.push(i);
        }
        return ans;
        
    }
    private int[] pse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }
            else ans[i]=st.peek();
            st.push(i);
        }
        return ans;
        
    }
}