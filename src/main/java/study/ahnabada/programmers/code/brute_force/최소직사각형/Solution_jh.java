package study.ahnabada.programmers.code.brute_force.최소직사각형;

import java.util.*;

public class Solution_jh {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < sizes.length; i++) {
            int tx = Math.max(sizes[i][0],sizes[i][1]);
            int ty = Math.min(sizes[i][0],sizes[i][1]);
            x = Math.max(x,tx);
            y = Math.max(y, ty);
        }

        return x*y;
    }
}
