package study.ahnabada.programmers.code.stack_queue.프린터;

import java.util.*;

class Solution_sj {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        //init
        LinkedList<Document> documents = new LinkedList<>();
        for (int i=0; i<priorities.length; i++){
            documents.add(new Document(i, priorities[i]));
        }

        //Run
        int order = 0;
        while (!documents.isEmpty()){            
            Document selected = documents.poll();

            boolean done = true;            
            for (Document doc : documents){
                if (selected.priority < doc.priority){
                    documents.offer(selected);
                    done = false;
                    break;
                }
            }

            if (!done)
                continue;

            order++;

            if (selected.location == location)
                return order;

        }


        return answer;
    }



    public static class Document {
        Document(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
        int location;
        int priority;  
    }

}