class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // candies + extra just need to be greater than the max candies in
        // from the child
        int max=0;
        for(int can : candies){
            max=Math.max(can,max);
        }
        List<Boolean> list = new ArrayList<>();
        for(int i : candies){
            if(i+extraCandies >= max){
                list.add(true);
            }
            else list.add(false);
        }
        return list;
    }
}