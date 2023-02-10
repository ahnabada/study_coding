package study.ahnabada.programmers.code.heap.이중우선순위큐;

import java.util.*;

class Solution_jh {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>((o1,o2) -> o1 - o2);
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1,o2) -> o2 - o1);

        for(String command: operations){
            executeCommand(command, maxQ, minQ);
        }
        if(minQ.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }

    public void executeCommand(String command, PriorityQueue<Integer> maxQ, PriorityQueue<Integer> minQ){
        Integer value;
        if(command.startsWith("I ")){
            value = Integer.valueOf(command.split(" ")[1]);
            minQ.offer(value);
            maxQ.offer(value);
        }else if(command.startsWith("D -")){
            value = minQ.poll();
            if(value != null){
                maxQ.remove(value);
            }
        }else{
            value = maxQ.poll();
            if(value != null){
                minQ.remove(value);
            }
        }
    }
}
