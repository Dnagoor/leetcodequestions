class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums,new ArrayList<>(),list,0);
        return list;
    }
    public void backTrack(int[] nums,List<Integer> ans,List<List<Integer>> list, int idx){
        list.add(new ArrayList<>(ans));
        for(int i=idx;i<nums.length;i++){
            ans.add(nums[i]);
            backTrack(nums,ans,list,i+1);
            ans.remove(ans.size()-1);
            
        }
    }
}