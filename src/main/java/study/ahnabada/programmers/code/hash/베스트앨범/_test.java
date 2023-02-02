package study.ahnabada.programmers.code.hash.베스트앨범;

import com.customizer.tester.TestCase;
import com.customizer.tester.helper.TestRunnerHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class _test extends TestRunnerHelper {

    @BeforeEach
    public void before() throws IOException, ClassNotFoundException {
        testRunner()
                .checker( (expected, result) -> {
                    assertArrayEquals( (int[])expected, (int[])result );
                });
    }
    
    
    @Test
    public void test1() throws Exception {
        testRunner().test(
                new TestCase()
                    .expected(
                            new int[]{ 4, 1, 3, 0 }
                    )
                    .parameters(
                            new String[]{ "classic", "pop", "classic", "classic", "pop" },
                            new int[]{ 500, 600, 150, 800, 2500 }
                    )
        );
    }


}
