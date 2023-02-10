package study.ahnabada.programmers.code.hash.전화번호_목록;

import java.util.*;

class Solution_jh {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> tree = new TreeSet<>();

        for(int i = 0; i<phone_book.length; i++){
            tree.add(phone_book[i]);
        }
        Iterator<String> itr = tree.iterator();
        String before = "test";
        while(itr.hasNext()){
            String next = itr.next();
            if(next.startsWith(before)){
                return false;
            }
            before = next;
        }

        return answer;
    }
}
