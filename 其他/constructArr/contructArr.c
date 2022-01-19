int* constructArr(int* a, int aSize, int* returnSize){
    if(aSize < 2){
        return a;
    }
    returnSize = &aSize;
    int * result = (int*)malloc(sizeof(int)*aSize);
    int prefix[aSize];
    int suffix[aSize];
    prefix[0] = a[0];
    suffix[aSize-1] = a[aSize-1];
    for(int i=1;i<aSize;i++){
        prefix[i] = prefix[i-1] * a[i];
    }
    for(int j=aSize-2;j>0;j--){
        suffix[j] = suffix[j+1] * a[j];
    }
    result[0] = suffix[1];
    result[aSize-1] = prefix[aSize-2];
    for(int k=1;k<aSize-1;k++){
        result[k] = prefix[k-1] * suffix[k+1];
    }
    for(int i=0;i<*returnSize;i++){
        printf("%d\n", result[i]);
    }
    return result;
}