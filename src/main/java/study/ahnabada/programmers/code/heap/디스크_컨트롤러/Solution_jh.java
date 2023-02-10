package study.ahnabada.programmers.code.heap.디스크_컨트롤러;

import java.util.*;

class Solution_jh {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = -1;
        int idx = 0;
        Queue<Job> pq = new PriorityQueue<>();

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){ //요청 시간이 동일한 경우 작업 시간이 짧은 것으로 정렬
                    return o1[1] - o2[1];
                } else{
                    return o1[0] - o2[0];
                }
            }
        });

        while(true){
            if(pq.isEmpty() && idx >= jobs.length)
                break;

            if(time == -1 || (idx < jobs.length && time < jobs[idx][0] && pq.isEmpty())){ // 작업이 비어 있는 경우
                Job temp = new Job(jobs[idx][0],jobs[idx][1]);
                temp.start = jobs[idx][0];
                idx++;
                time = temp.start + temp.job;
                answer += temp.job;
            }
            while(idx < jobs.length){ // 현재 작업의 예상 작업 완료 시간 내에 다른 요청이 있는 경우
                if(jobs[idx][0] <= time){
                    pq.offer(new Job(jobs[idx][0],jobs[idx][1]));
                    idx++;
                }else
                    break;
            }
            while(!pq.isEmpty()){ // 최단 작업이 될수 있는 작업을 꺼내어 계산
                Job j = pq.poll();
                answer += j.job + time - j.req_time;
                time += j.job;
                break;
            }
        }
        return answer/jobs.length;
    }

    class Job implements Comparable<Job>{
        int req_time;
        int start;
        int job;

        public Job(int req_time, int job){
            this.req_time = req_time;
            start = req_time;
            this.job = job;
        }

        @Override
        public int compareTo(Job j){
            return this.job - j.job;
        }
    }
}
