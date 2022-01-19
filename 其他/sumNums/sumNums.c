int sumNums(int n){
    bool flag = n > 0 && (n+=sumNums(n-1)) > 0;
    return n;
}