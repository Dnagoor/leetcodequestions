class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fact =1;
        for(int i =1;i<n;i++){
            fact=fact*i;
            list.add(i);
        }
        list.add(n);
        k--;
        StringBuilder ans = new StringBuilder();
        while(true){
            int idx=k/fact;
            ans.append(list.get(idx));
            list.remove(idx);
            if(list.size()==0) break;
            k=k%fact;
            fact=fact/list.size();

            
        }
        return ans.toString();
        
    }
}