package study.ahnabada.programmers.code.hash.폰켓몬;

import com.customizer.tester.TestCase;
import com.customizer.tester.helper.TestRunnerHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _test extends TestRunnerHelper {

    @BeforeEach
    public void before() throws IOException, ClassNotFoundException {
        testRunner()
                .checker( (expected, result) -> {
                    assertEquals(expected, result);
                });
    }


    @Test
    public void test1() throws Exception {
        testRunner().test(
                new TestCase()
                        .expected(2)
                        .parameters(
                                new int[]{ 3,1,2,3 }
                        )
        );
    }

    @Test
    public void test2() throws Exception {
        testRunner().test(
                new TestCase()
                        .expected(3)
                        .parameters(
                                new int[]{ 3,3,3,2,2,4 }
                        )
        );
    }

    @Test
    public void test3() throws Exception {
        testRunner().test(
                new TestCase()
                        .expected(2)
                        .parameters(
                                new int[]{ 3,3,3,2,2,2 }
                        )
        );
    }

}
