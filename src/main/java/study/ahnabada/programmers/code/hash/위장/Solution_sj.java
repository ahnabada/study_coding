package study.ahnabada.programmers.code.hash.위장;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_sj {
    
    Map<String, List<String>> clothesByType = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for (String[] clothe : clothes){
            String name = clothe[0];
            String type = clothe[1];
            
            List<String> names = clothesByType.get(type);
            if (names == null){
                names = new ArrayList<>();
                clothesByType.put(type, names);
            }
            names.add(name);
        }
        
        for (String type : clothesByType.keySet()){
            List<String> names = clothesByType.get(type);
            answer *= (names.size() + 1);
        }
        
        
        return answer -1;
    }
}