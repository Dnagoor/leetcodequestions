class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less=0,equal=0;
        for(int i : nums){
            if(i<target){
                less++;
            }
            else if(i==target){
                equal++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<equal;i++){
            list.add(less+i);
        }
        return list;
    }
}