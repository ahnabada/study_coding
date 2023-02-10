package study.ahnabada.programmers.code.hash.위장;

import java.util.*;
class Solution_jh {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hm = new HashMap<>();

        int[] count;
        for(int i=0;i<clothes.length;i++) {
            if(!hm.containsKey(clothes[i][1])) {
                hm.put(clothes[i][1], 1);
            }else {
                hm.put(clothes[i][1],hm.get(clothes[i][1])+1);
            }
        }

        count = new int[hm.size()];
        Iterator<String> it = hm.keySet().iterator();
        int j=0;
        while(it.hasNext()) {
            count[j++] = hm.get(it.next());
        }
        for(int i =0;i<count.length;i++) answer*=(1+count[i]);
        return answer-1;
    }
}