package study.ahnabada.programmers.code.sort.h_Index;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_jh {
    public int solution(int[] citations) {
        int answer = 0;
        int h_index = citations.length;
        int len = citations.length;
        int cnt = 0;
        int idx = 0;

        List<Integer> list = Arrays.stream(citations).boxed().collect(Collectors.toList());
        list.sort((o1, o2) -> o2-o1);

        while(true){
            int temp = list.get(idx);
            if(h_index <= temp){
                cnt++;
                idx++;
            } else{
                h_index--;
            }

            if(cnt >= h_index && (len - cnt) <= h_index){
                answer = h_index;
                break;
            }
        }
        return answer;
    }
}
