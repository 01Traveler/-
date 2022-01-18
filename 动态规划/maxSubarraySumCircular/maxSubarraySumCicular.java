class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxVal = Integer.MIN_VALUE, minVal=Integer.MAX_VALUE;
        int current_max = 0, current_min=0;
        int total = 0;
        for(int x : nums){
            total+=x;
            current_max = Math.max(current_max+x,x);
            current_min = Math.min(current_min+x,x);
            maxVal = current_max > maxVal ? current_max : maxVal;
            minVal = current_min < minVal ? current_min : minVal;
        }
        return maxVal > 0 ? Math.max(maxVal, total-minVal) : maxVal; 
    }
}