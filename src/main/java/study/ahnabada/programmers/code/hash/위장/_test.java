package study.ahnabada.programmers.code.hash.위장;

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
                                5
                        )
                        .parameters(
                                new String[][]{
                                    new String[]{"yellow_hat", "headgear"},
                                    new String[]{"blue_sunglasses", "eyewear"},
                                    new String[]{"green_turban", "headgear"}
                                }
                        )
        );
    }

    @Test
    public void test2() throws Exception {
        testRunner().test(
                new TestCase()
                        .expected(
                                3
                        )
                        .parameters(
                                new String[][]{
                                    new String[]{"crow_mask", "face"},
                                    new String[]{"blue_sunglasses", "face"},
                                    new String[]{"smoky_makeup", "face"}
                                }
                        )
        );
    }

}
