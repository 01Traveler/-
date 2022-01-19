int _pow(int i, int j){
    int k=1;
    while(j--) k*=i;
    return k;
}

int cuttingRope(int n){
    if(n<4){
        return n-1;
    }
    int a = n/3;
    int b = n%3;
    if(b==0){
        return _pow(3,a); 
    }
    else if(b == 1){
        return _pow(3, a-1) * 4;
    }
    else{
        return _pow(3,a) * 2;
    }
}