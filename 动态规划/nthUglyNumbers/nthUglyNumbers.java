class Solution {
    public int nthUglyNumber(int n) {
        int p2=1,p3=1,p5=1;
        for(int i=2;i<n+1;i++){
            int next = Math.min(Math.min(p2*2, p3*3), p5*5);
            //System.out.println(pre + ",  " + p2*2 +", " + p3*3 + "," + p5*5);
            if(next == p2*2){
                pre = p2*2;
                p2+=1;
            }
            if(next == p3*3){
                pre = p3*3;
                p3+=1;
            }
            if(next == p5*5){
                pre = p5*5;
                p5++;
            }
        }
        return pre;
    }
}