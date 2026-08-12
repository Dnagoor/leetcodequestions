class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        int l = 0 , r=0 , res =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r< arr.length){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.get(arr[r]) > k){
                map.put(arr[l],map.get(arr[l])-1);
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
            
        }
        return res;

        
    }
}