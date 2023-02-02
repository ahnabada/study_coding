package study.ahnabada.programmers.code.stack_queue.올바른_괄호;

class Solution_sj {
    
    boolean solution(String s) {
        int check = 0;
        
        for (char c : s.toCharArray()){
            if (c == '('){
                check++;
            }else if (c == ')' && --check < 0){
                return false;
            }
        }
        
        return check == 0;
    }
    
}