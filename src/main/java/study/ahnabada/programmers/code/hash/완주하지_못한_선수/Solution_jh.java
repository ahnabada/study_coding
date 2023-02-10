package study.ahnabada.programmers.code.hash.완주하지_못한_선수;

import java.util.*;
class Solution_jh {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for (String p: participant){
            map.put(p, map.getOrDefault(p,0) +1);
        }

        for(String p: completion){
            map.put(p,map.get(p)-1);
            if(map.get(p) == 0){
                map.remove(p);
            }
        }
        return map.entrySet().iterator().next().getKey();
    }

}
