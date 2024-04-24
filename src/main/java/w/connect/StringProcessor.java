package w.connect;

/**
 * Interface for processing strings.
 */
public interface StringProcessor {
    /**
     * Processes the input string and returns the processed string.
     *
     * @param input the input string to be processed
     * @return the processed string
     */
    String process(String input);

    boolean shouldProcess(String input);
}