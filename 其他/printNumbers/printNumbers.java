class Solution {
    public int[] printNumbers(int n) {
        int limit = (int) Math.pow(10,n);
        int[] result = new int[limit-1];
        int i=1;
        while(i<limit) result[i-1] = (i++);
        return result;
    }
}