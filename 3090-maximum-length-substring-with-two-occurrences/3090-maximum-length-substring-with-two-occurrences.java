class Solution {
    public int maximumLengthSubstring(String s) {
        int low = 0 , high =0;
        int max=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(high < s.length()){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>2){
                char left =s.charAt(low);
                map.put(left,map.get(left)-1);
                low++;
            }
            max= Math.max(max,high-low+1);
            high++;

        }
        return max;
        
    }
}