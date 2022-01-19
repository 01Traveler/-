class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len < 2){
            return a;
        }
        int[] prefix = new int[len];
        prefix[0] = a[0];
        int[] suffix = new int[len];
        int[] result = new int[len];
        suffix[len-1] = a[len-1];
        for(int idx=1;idx<len;idx++){
            prefix[idx] = prefix[idx-1] * a[idx];
        }
        for(int idx=len-2;idx>0;idx--){
            suffix[idx] = suffix[idx+1] * a[idx];
        }
        result[0] = suffix[1];
        result[len-1] = prefix[len-2];
        for(int idx=1;idx<len-1;idx++){
            result[idx] = prefix[idx-1] * suffix[idx+1];
        }
        return result;
    }
}