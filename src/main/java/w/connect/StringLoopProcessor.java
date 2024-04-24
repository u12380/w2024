package w.connect;

/**
 * A StringProcessor that loops until the input stops changing.
 */
public class StringLoopProcessor implements StringProcessor {

    StringProcessor processor;

    public StringLoopProcessor(StringProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String process(String input) {
        while (true) {
            String processed = processor.process(input);
            if (input.equals(processed)) {
                return processed;
            }
            input = processed;
        }
    }

    @Override
    public boolean shouldProcess(String input) {
        return true;
    }
}
