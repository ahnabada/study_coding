package study.ahnabada.programmers.code.hash.완주하지_못한_선수;

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
                    .expected(
                            "leo"
                    )
                    .parameters(
                            new String[]{ "leo", "kiki", "eden" },
                            new String[]{ "eden", "kiki" }
                    )
        );
    }

    @Test
    public void test2() throws Exception {
        testRunner().test(
                new TestCase()
                    .expected(
                            "vinko"
                    )
                    .parameters(
                            new String[]{ "marina", "josipa", "nikola", "vinko", "filipa" },
                            new String[]{ "josipa", "filipa", "marina", "nikola" }
                    )
        );
    }

    @Test
    public void test3() throws Exception {
        testRunner().test(
                new TestCase()
                    .expected(
                            "mislav"
                    )
                    .parameters(
                            new String[]{ "mislav", "stanko", "mislav", "ana" },
                            new String[]{ "stanko", "ana", "mislav" }
                    )
        );
    }


}
