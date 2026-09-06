class Solution {
    public void per(int[] arr, int idx,List<List<Integer>> list){
        if(idx==arr.length){
            List<Integer> ans = new ArrayList<>();
            for(int i : arr){
                ans.add(i);
            }
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i =idx;i<arr.length;i++){
            swap(idx,i,arr);// swap
            per(arr,idx+1,list);//call function
            swap(idx,i,arr);// undo
        }
    }


    public void swap(int i , int j , int[] arr){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        per(nums,0,list);
        return list;

        
    }
}