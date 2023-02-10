package study.ahnabada.programmers.code.stack_queue.다리를_지나는_트럭;


import java.util.*;
import java.util.stream.Collectors;;
public class Solution_jh {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int next = 0;
        int current_weight = 0;
        List<Integer> in = new ArrayList<>();
        List<Integer> times = new ArrayList<>();

        in.add(truck_weights[0]);
        times.add(bridge_length);
        current_weight += truck_weights[0];
        answer++;
        next++;

        while(!in.isEmpty()){

            times = times.stream().map(i->i-1).collect(Collectors.toList());

            answer++;

            if(times.get(0) == 0){
                times.remove(0);
                current_weight -= in.remove(0);
            }


            if(next < truck_weights.length){
                int temp = truck_weights[next];
                if(current_weight + temp <= weight && in.size() <= bridge_length){
                    in.add(temp);
                    times.add(times.size(),bridge_length);
                    current_weight += temp;
                    next++;
                }
            }
        }
        return answer;
    }
}