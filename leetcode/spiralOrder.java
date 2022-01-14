//顺时针打印二维列表
//解题思路为模拟，主要有两个需要注意的地方，第一个为输入为空时，第二个为动态边界的确定
//时间复杂度为O(n),空间复杂度为O(n)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=n;
        int bottom=0;
        int top=m;
        int cnt = 0;
        int[] result = new int[m*n];
        while(cnt < matrix[0].length * matrix.length){
            //System.out.println("left : " + left + ", right : " + right + ", bottom : " + bottom + ", top : " + top);
            for(int i=left;i<right && top>bottom;i++){
                result[cnt] = matrix[bottom][i];
                cnt++;
            }
            bottom+=1;
            for(int j=bottom;j<top && left<right;j++){
                result[cnt] = matrix[j][right-1];
                cnt++;
            }
            right-=1;
            for(int i=right-1;i>=left && top>bottom;i--){
                result[cnt] = matrix[top-1][i];
                cnt++;
            }
            top-=1;
            for(int j=top-1;j>=bottom && left < right;j--){
                result[cnt] = matrix[j][left];
                cnt++;
            }
            left+=1;
        }
        return result;
    }
}
