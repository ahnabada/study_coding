package study.ahnabada.programmers.code.stack_queue.주식가격;

//풀이 2 성공 - 다른 파이썬 코드 참조했음
import java.util.*;
import java.util.stream.Collectors;

class Solution_jh {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<Integer>(); // -> 이 부분을 ArrayList로하면 시간 효율 초과
        int idx = 0;
        q.addAll(Arrays.stream(prices).boxed().collect(Collectors.toList()));

        while(!q.isEmpty()){
            int now = q.poll();
            int time = 0;

            for(int i: q){
                time++;
                if(now > i){
                    break;
                }
            }
            answer[idx++] = time;
        }
        return answer;
    }
}