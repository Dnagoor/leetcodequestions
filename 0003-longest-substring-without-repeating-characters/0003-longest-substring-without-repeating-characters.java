class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0 , maxlen=0;
        int[] lastseen = new int[128];
        for(int i =0 ; i<lastseen.length;i++){
            lastseen[i]=-1;
        }
        while(r<s.length()){
            char ch = s.charAt(r);
            if(lastseen[ch]!=-1){
                l=Math.max(l,lastseen[ch]+1);

            }
            maxlen=Math.max(maxlen,r-l+1);
            lastseen[ch]=r;
            r++;
        }
        
        return maxlen;
    }
}