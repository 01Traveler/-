class Solution {
    public String reverseWords(String s) {
        int left=0,right=s.length()-1;
        while(s.charAt(left) == ' ') left++;
        while(s.charAt(right) == ' ') right--;
        Deque<String> dq = new ArrayDeque<String>();
        StringBuilder tmp = new StringBuilder();
        for(int i=left;i<=right;i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                if(tmp.length() != 0) dq.offerFirst(tmp.toString());
                tmp.setLength(0);
            }
            else{
                tmp.append(ch);
            }
        }
        if(tmp.length() != 0) dq.offerFirst(tmp.toString());
        return String.join(" ", dq);
    }
}