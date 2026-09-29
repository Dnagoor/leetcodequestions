class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        int rev=0;
        while(num!=0){
            int Last_dig = num% 10;
            if(rev > (Integer.MAX_VALUE-Last_dig)/10){
                return 0;

            }
            rev = rev*10+Last_dig;
            num= num /10;
        }
        return (x<0) ? (-rev) : (rev);
    }
}