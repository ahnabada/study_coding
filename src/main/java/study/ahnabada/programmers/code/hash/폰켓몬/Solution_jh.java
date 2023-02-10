package study.ahnabada.programmers.code.hash.폰켓몬;

import java.util.*;

class Solution_jh {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;
        Set<Integer> mon_set = new HashSet<>();

        for(int i : nums){
            mon_set.add(i);
        }
        answer = mon_set.size();

        if(answer < n){
            return answer;
        }else{
            return n;
        }

    }
}
