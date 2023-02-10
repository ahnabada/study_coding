package study.ahnabada.programmers.code.stack_queue.프린터;

import java.util.*;
class Solution_jh {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pool> prior_q = new PriorityQueue<>();
        Queue<Pool> wait_q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i<priorities.length; i++){
            Pool p = new Pool(i, priorities[i]);
            prior_q.offer(p);
            wait_q.offer(p);
        }
        while(!wait_q.isEmpty()){
            Pool prior_p = prior_q.poll();
            Pool wait_p = wait_q.poll();
            if(prior_p.getPriority() == wait_p.getPriority()){
                result.add(wait_p.getLoc());
            }else if(prior_p.getPriority() > wait_p.getPriority()){
                wait_q.offer(wait_p);
                prior_q.offer(prior_p);
            }
        }
        for(int i=0;i<result.size();i++){
            if(location == result.get(i))
                answer = i+1;
        }
        return answer;
    }

    class Pool implements Comparable<Pool>{
        private int loc;
        private int priority;

        public Pool(int loc, int priority){
            this.loc = loc;
            this.priority = priority;
        }
        public int getLoc(){
            return loc;
        }
        public int getPriority(){
            return priority;
        }
        @Override
        public int compareTo(Pool s){
            return s.priority - priority;
        }
    }
}