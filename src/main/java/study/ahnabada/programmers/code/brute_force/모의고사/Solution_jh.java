package study.ahnabada.programmers.code.brute_force.모의고사;

import java.util.*;

public class Solution_jh {
    public int[] solution(int[] answers){
        int[] answer = {};
        int[] cnts = {0,0,0};
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == p1[i%5]) cnts[0]++;
            if(answers[i] == p2[i%8]) cnts[1]++;
            if(answers[i] == p3[i%10]) cnts[2]++;
        }
        int max = Math.max(cnts[0],Math.max(cnts[1],cnts[2]));
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < cnts.length; i++) {
            if(max == cnts[i]){
                lst.add(i+1);
            }
        }
        answers = lst.stream().mapToInt(i->i).toArray();

        return answers;

    }
}
