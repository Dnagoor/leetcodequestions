    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> list = new ArrayList<>();
            List<String> ans = new ArrayList<>();
            solve(0,s,list,ans);
            return list;
            

        }

        public void solve(int idx,String s, List<List<String>> list , List<String> ans){
            if(idx== s.length()){
                list.add(new ArrayList<>(ans));
                return;
            }
            for(int i=idx; i<s.length();i++){
                if(isPalindrome(s,idx,i)){
                    ans.add(s.substring(idx,i+1));
                    solve(i+1,s,list,ans);
                    ans.remove(ans.size()-1);
                }
            }
        }
        public boolean isPalindrome(String s , int i , int j){
            while(i <= j){
                if(s.charAt(i)!=s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
    }
