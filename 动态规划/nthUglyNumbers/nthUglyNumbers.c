int nthUglyNumber(int n){
    int items[n+1];
    items[0] = 0;
    items[1] = 1;
    int p2=1,p3=1,p5=1;
    for(int i=2;i<n+1;i++){
        int num2 = items[p2] * 2;
        int num3 = items[p3] * 3;
        int num5 = items[p5] * 5;
        int min = num2 > num5 ?  num5 : num2;
        min = min > num3 ? num3 : min;
        items[i] = min;
        if(min == num2){
            p2++;
        }
        if(min == num3){
            p3++;
        }
        if(min == num5){
            p5++;
        }
    }
    return items[n];
}