package study.ahnabada.programmers.code.sort.k번째수;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_jh {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i<commands.length; i++){
            answer[i] = execute(array, commands[i]);
        }
        return answer;
    }

    private int execute(int[] array, int[] com){
        int[] temp = Arrays.copyOfRange(array,com[0]-1,com[1]);
        Arrays.sort(temp);
        return temp[com[2]-1];
    }
}
