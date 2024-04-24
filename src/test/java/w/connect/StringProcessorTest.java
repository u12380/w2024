package w.connect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class StringProcessorTest {

    /**
     * Test case for stage 1 of the challenge.
     */
    @Test
    public void stage1() {
        StringLoopProcessor processor = new StringLoopProcessor(new ConsecutiveCharactersRemover());
        assertEquals("d", processor.process("aabcccbbad"));
    }

    /**
     * Test case for stage 2 of the challenge.
     */
    @Test
    public void stage2() {
        StringLoopProcessor processor = new StringLoopProcessor(new ConsecutiveCharactersReplacer());
        assertEquals("d", processor.process("abcccbad"));
    }

    /**
     * Test case for input is null.
     */
    @Test
    public void testInputIsNull() {
        StringLoopProcessor processor = new StringLoopProcessor(new ConsecutiveCharactersReplacer());
        assertThrowsExactly(IllegalArgumentException.class, () -> processor.process(null));
    }

    /**
     * Test case for input is not alphabetic.
     */
    @Test
    public void testInputIsNotAlphabetic() {
        StringLoopProcessor processor = new StringLoopProcessor(new ConsecutiveCharactersReplacer());
        assertThrowsExactly(IllegalArgumentException.class, () -> processor.process("ab99A"));
    }
}
