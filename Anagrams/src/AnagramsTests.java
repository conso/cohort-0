import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AnagramsTests {
    @Test
    @Parameters({
            "a, a",
            "b, b",
            "c, c",
            "ab, ab ba",
            "bc, bc cb",
    })

    public void solveAnagram(String input, String expected) {
        Anagrams anagrams = new Anagrams();
        assertThat(anagrams.solve(input), is(expected));
    }
}