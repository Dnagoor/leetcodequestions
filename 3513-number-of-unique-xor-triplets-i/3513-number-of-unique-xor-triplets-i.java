class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        // Base case: If array size is 1 or 2, we can only form 'n' unique results
        if (n <= 2) {
            return n;
        }
        
        // Calculate the total number of bits required to represent 'n'
        int bits = 32 - Integer.numberOfLeadingZeros(n);
        
        // The total number of unique values is the next power of 2
        return 1 << bits;
    }
}
