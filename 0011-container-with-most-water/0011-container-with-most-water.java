class Solution {
    public int maxArea(int[] arr) {
        int i=0 , j=arr.length-1, max=0;
        while(i < j){
            int w= j-i;
            int h= Math.min(arr[i], arr[j]);

            int area = w * h;
            max= Math.max(max,area);

            if(arr[i]< arr[j]){
                i++;
            } 
            else j--;
        }
        return max;
        
    }
}