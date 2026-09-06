class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] usedIndex = new boolean[nums.length];
        per(nums,usedIndex,list,new ArrayList<>());
        return list;
        
    }
    public void per(int[] arr, boolean[] usedIdx , List<List<Integer>> list, List<Integer> ans){
        if(ans.size()==arr.length){
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i =0;i<arr.length;i++){
            if(usedIdx[i]) continue;
            ans.add(arr[i]);
            usedIdx[i]=true;
            per(arr,usedIdx,list,ans);
            usedIdx[i]=false;
            ans.remove(ans.size()-1);
        }
    }
}