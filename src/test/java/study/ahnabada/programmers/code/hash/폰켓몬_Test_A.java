package study.ahnabada.programmers.code.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 각 Solution 마다 상속(extends) 받을 것을 요구하는 방식
 *      - 장점: 명확
 *      - 단점: Solution 개발자들이 귀찮아질 듯!
 */
public abstract class 폰켓몬_Test_A {

    abstract int solution(int[] nums);

    @Test
    public void sample(){
        assertEquals(
                solution(new int[]{ 3,1,2,3 }),
                2
        );
    }

    @Test
    public void sample1(){
        assertEquals(
                solution(new int[]{ 3,3,3,2,2,4 }),
                3
        );
    }

    @Test
    public void sample2(){
        assertEquals(
                solution(new int[]{ 3,3,3,2,2,2 }),
                2
        );
    }

}
