package study.ahnabada.programmers.code.stack_queue.기능개발;

import java.util.*;

class Solution_sj {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        
        int cursor = 0;
        int beforeCursor = 0;
        while (cursor < progresses.length){
            beforeCursor = cursor;
            
            //Progress
            for (int i=cursor; i<progresses.length; i++){
                progresses[i] += speeds[i];
            }   
            
            //Check
            while (cursor < progresses.length && progresses[cursor] >= 100){
                ++cursor;
            }
            
            //Calculate
            if (cursor != beforeCursor){
                q.add( cursor - beforeCursor );
            }
        }
        
        //Return
        int[] answer = new int[q.size()];
        for (int i=0; i<q.size(); i++){
            answer[i] = q.get(i);
        }
        
        return answer;
    }
}