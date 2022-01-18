class Solution {
    public int numSquares(int n) {
        int point = 0;
        int[] vol = new int[n+1];
        vol[0] = 0;
        for(int i=1;i<n+1;i++){
            if(i==(point+1)*(point+1)){
                point++;
                vol[i] = 1;
            }
            else{
                int min = 99999;
                for(int j=1;j<point+1;j++){
                    if(min > vol[j*j] + vol[i-j*j]){
                        min = vol[j*j] + vol[i-j*j]; 
                    }
                }
                vol[i] = min;
            }
        }
        return vol[n];
    }
}