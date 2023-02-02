package study.ahnabada.programmers.code.hash.폰켓몬;

import java.util.Collections;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Solution_sj {

    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // for (int num : nums){
        //     set.add(num);
        // }

        Integer[] nnn = IntStream.of(nums).boxed().toArray(Integer[]::new);

        Collections.addAll(set, nnn);

        int maxCount = nums.length /2;
        int maxType = set.size();
        int answer = Math.min(maxCount, maxType);
        return answer;
    }

}
