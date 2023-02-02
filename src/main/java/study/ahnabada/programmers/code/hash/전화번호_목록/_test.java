package study.ahnabada.programmers.code.hash.전화번호_목록;

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
                                false
                        )
                        .parameters(
                                new String[]{"119", "97674223", "1195524421"}
                        )
        );
    }

    @Test
    public void test2() throws Exception {
        testRunner().test(
                new TestCase()
                        .expected(
                                true
                        )
                        .parameters(
                                new String[]{"123","456","789"}
                        )
        );
    }

    @Test
    public void test3() throws Exception {
        testRunner().test(
                new TestCase()
                        .expected(
                                false
                        )
                        .parameters(
                                new String[]{"12","123","1235","567","88"}
                        )
        );
    }

}
