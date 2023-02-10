package study.ahnabada.programmers.code.stack_queue.올바른_괄호;

// 풀이 2

import java.util.*;

class Solution_jh {
    boolean solution(String s){
        boolean answer = true;
        int start = 0;

        int base = 0;

        if(s.startsWith(")")) return false;
        if(s.length()%2 == 1) return false;

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '(') base++;
            else base--;

            if(base <0){
                return false;
            }
        }
        if(base !=0) return false;
        return answer;
    }
}
