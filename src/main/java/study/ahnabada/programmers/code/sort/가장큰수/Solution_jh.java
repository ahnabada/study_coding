package study.ahnabada.programmers.code.sort.가장큰수;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_jh {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int initMax = Arrays.stream(numbers).max().getAsInt();
        if(initMax == 0){
            return "0";
        }

        for(int i: numbers){
            queue.offer(String.valueOf(i).repeat(3));
        }
        while(!queue.isEmpty()){
            String temp = queue.poll();
            answer.append(temp.substring(0,temp.length()/3));
        }
        return answer.toString();
    }
}
