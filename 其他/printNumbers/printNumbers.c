int* printNumbers(int n, int* returnSize){
    int size = pow(10,n)-1;
    int* result = (int*) malloc(sizeof(int) * size);
    int i=1;
    while(i<size) result[i-1] = (i++);
    return result;
}