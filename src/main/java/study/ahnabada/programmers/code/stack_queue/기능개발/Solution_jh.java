package study.ahnabada.programmers.code.stack_queue.기능개발;

import java.util.*;
class Solution_jh {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();
        int temp =0;
        int count = 0;
        for(int i = 0; i<progresses.length;i++) {
            p.add(progresses[i]);
            s.add(speeds[i]);
        }
        int day = 0;
        while(p.size() !=0) {
            int front = p.peek();
            if(front + day*s.peek() >= 100){
                count++;
                p.poll();
                s.poll();
            }else{
                day++;
                if(count != 0){
                    arr.add(count);
                    count = 0;
                }
            }

        }
        arr.add(count);
        answer = new int[arr.size()];
        for(int i =0; i<answer.length;i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
