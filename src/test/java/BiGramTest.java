import com.gohealth.main.business.BiGram;
import com.gohealth.main.business.NGram;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class BiGramTest {
    private NGram biGram;
    private String testString1 = "The quick brown fox and the quick blue hare";
    private String testString2 = "The quick brown fox, the quick blue hare, the quick blue sparrow, the lazy green turtle and the lazy white cat went out to party in a bar downtown. However, when they got there, the bar downtown was closed";
    private LinkedHashMap<String, Integer> expectedValue1 = new LinkedHashMap<>();
    private LinkedHashMap<String, Integer> expectedValue2 = new LinkedHashMap<>();

    /**
     * Initializes the variables.
     */
    @Before
    public void setUp() {
        biGram = new BiGram();

        expectedValue1.put("the quick", 2);
        expectedValue1.put("quick brown", 1);
        expectedValue1.put("brown fox", 1);
        expectedValue1.put("fox and", 1);
        expectedValue1.put("and the", 1);
        expectedValue1.put("quick blue", 1);
        expectedValue1.put("blue hare", 1);

        expectedValue2.put("the quick", 3);
        expectedValue2.put("quick brown", 1);
        expectedValue2.put("brown fox", 1);
        expectedValue2.put("fox the", 1);
        expectedValue2.put("quick blue", 2);
        expectedValue2.put("blue hare", 1);
        expectedValue2.put("hare the", 1);
        expectedValue2.put("blue sparrow", 1);
        expectedValue2.put("sparrow the", 1);
        expectedValue2.put("the lazy", 2);
        expectedValue2.put("lazy green", 1);
        expectedValue2.put("green turtle", 1);
        expectedValue2.put("turtle and", 1);
        expectedValue2.put("and the", 1);
        expectedValue2.put("lazy white", 1);
        expectedValue2.put("white cat", 1);
        expectedValue2.put("cat went", 1);
        expectedValue2.put("went out", 1);
        expectedValue2.put("out to", 1);
        expectedValue2.put("to party", 1);
        expectedValue2.put("party in", 1);
        expectedValue2.put("in a", 1);
        expectedValue2.put("a bar", 1);
        expectedValue2.put("bar downtown", 2);
        expectedValue2.put("downtown however", 1);
        expectedValue2.put("however when", 1);
        expectedValue2.put("when they", 1);
        expectedValue2.put("they got", 1);
        expectedValue2.put("got there", 1);
        expectedValue2.put("there the", 1);
        expectedValue2.put("the bar", 1);
        expectedValue2.put("downtown was", 1);
        expectedValue2.put("was closed", 1);
    }

    /**
     * Tests if the histogram is generated correctly.
     */
    @Test
    public void calcHistogramShouldPopulateHistogramCorrectlyTest() {
        LinkedHashMap<String, Integer> actualValue1 = biGram.generate(testString1);
        assertEquals(expectedValue1, actualValue1);

        LinkedHashMap<String, Integer> actualValue2 = biGram.generate(testString2);
        assertEquals(expectedValue2, actualValue2);
    }

    /**
     * Tests if the histogram is printed correctly.
     */

    @Test
    public void printHistogramShouldPrintHistogramCorrectlyTest() {
        String expectedValue = "* 'the quick' 2" + System.lineSeparator() +
                "* 'quick brown' 1" + System.lineSeparator() +
                "* 'brown fox' 1" + System.lineSeparator() +
                "* 'fox and' 1" + System.lineSeparator() +
                "* 'and the' 1" + System.lineSeparator() +
                "* 'quick blue' 1" + System.lineSeparator() +
                "* 'blue hare' 1" + System.lineSeparator();
        final ByteArrayOutputStream actualValue = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualValue));

        LinkedHashMap<String, Integer> histogram = biGram.generate(testString1);
        biGram.print(histogram);
        assertEquals(expectedValue, actualValue.toString());
    }

    /**
     * Tests if the sanitization method removes the punctuation correctly.
     */

    @Test
    public void sanitizeTextShouldRemovePunctuationTest() {
        String testString = "the fox. the fox";
        LinkedHashMap<String, Integer> actualValue = biGram.generate(testString);
        assertEquals(2, actualValue.get("the fox").intValue());
    }

    /**
     * Tests if the sanitization method removes the extra white spaces correctly.
     */

    @Test
    public void sanitizeTextShouldRemoveExtraWhiteSpacesTest() {
        String testString = "the fox.  the fox";
        LinkedHashMap<String, Integer> actualValue = biGram.generate(testString);
        assertEquals(2, actualValue.get("the fox").intValue());
    }

    /**
     * Tests if the sanitization method works ignoring the captalization.
     */

    @Test
    public void sanitizeTextShouldDowncasesAllLettersTest() {
        String testString = "ThE foX. THE fox";
        LinkedHashMap<String, Integer> actualValue = biGram.generate(testString);
        assertEquals(2, actualValue.get("the fox").intValue());
    }
}
