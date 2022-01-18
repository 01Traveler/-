int numSquares(int n){
    int numSquareList[n+1];
    numSquareList[0]=0;
    int point=0;
    for(int i=1;i<n+1;i++){
        int next_point = point+1;
        if(next_point*next_point == i){
            point = next_point;
            next_point ++;
            numSquareList[i] = 1;
        }
        else{
            int min = 99999;
            for(int j=1;j<point+1;j++){
                min = numSquareList[j*j] + numSquareList[i-j*j] < min ? numSquareList[j*j] + numSquareList[i-j*j] : min;
            }
            numSquareList[i] = min;
        }
    }
    return numSquareList[n];
}