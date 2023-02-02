package study.ahnabada.programmers.code.stack_queue.같은_숫자는_싫어;

import java.util.*;

public class Solution_sj {
    
    public int[] solution(int []arr) {
        
        LinkedList<Integer> q = new LinkedList<>();
        for (int o : arr)
            q.add(o);
        
        List<Integer> result = new ArrayList<>();
        Integer e = null, last = null;
    
        while ( (e = q.poll()) != null ){
            if (e == last)
                continue;
            result.add(e);    
            last = e;
        }
        
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++)
            answer[i] = result.get(i);
    
        
        return answer;
    }
}