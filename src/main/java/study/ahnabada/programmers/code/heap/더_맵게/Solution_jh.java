package study.ahnabada.programmers.code.heap.더_맵게;

import java.util.*;
import java.util.stream.Collectors;
class Solution_jh {
    public int solution(int[] scoville, int k){
        int answer = 0;

        Queue<Integer> pq = new PriorityQueue<Integer>();
        pq.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        while(pq.peek() < k){
            if(pq.size() == 1){
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second*2);
            answer++;
        }

        return answer;
    }
}