package study.ahnabada.programmers.code.stack_queue.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_he {


    public static void main(String[] args) {
        System.out.println(function_queue(2,10, new int[]{7,4,5,6}));
        System.out.println(function_queue(100,100, new int[]{10}));
        System.out.println(function_queue(100,100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

    private static int function_queue(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for(int truck: truck_weights){
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                }else if(queue.size() == bridge_length){
                    sum -= queue.poll();
                }else{
                    if(sum + truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else{
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }



}
