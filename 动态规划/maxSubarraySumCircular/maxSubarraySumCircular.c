int maxSubarraySumCircular(int* nums, int numsSize){
    int total=0,max=-99999,min=99999,curMax=0,curMin=0;
    for(int j=0;j<numsSize;j++){
        int i = nums[j];
        total+=i;
        curMax = curMax+i > i ? curMax+i : i;
        curMin = curMin+i < i ? curMin+i : i;
        max = curMax > max ? curMax : max;
        min = curMin < min ? curMin : min;
    }
    //printf("%d,%d", max, min);
    return max > 0 ? (total-min > max ? total-min : max) : max;
}