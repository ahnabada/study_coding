package study.ahnabada.programmers.code.hash.완주하지_못한_선수;

import java.util.Arrays;

public class Soultion_test_wrong1 {

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i=0; i<participant.length -1; i++){
            if (!participant[i].equals(completion[i]))
                return participant[i];
        }

        return participant[participant.length -1] +"asdf";
    }


}
