package study.ahnabada.programmers.code.stack_queue.같은_숫자는_싫어;

import java.util.*;

public class Solution_jh {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> a = new Stack<>();
        a.push(arr[0]);

        for(int i = 1; i<arr.length; i++){
            int temp = a.pop();
            if(temp == arr[i]) a.push(temp);
            else{
                a.push(temp);
                a.push(arr[i]);
            }
        }
        answer = new int[a.size()];

        for(int i = answer.length-1; i>=0; i--){
            answer[i] = a.pop();
        }
        return answer;
    }
}