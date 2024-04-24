package w.connect;

import java.util.regex.Matcher;

/**
 * This class removes consecutive characters from the input string.
 */
public class ConsecutiveCharactersRemover extends AbstractConsecutiveCharactersProcessor {

    @Override
    public String process(String input) {
        if(!shouldProcess(input)) {
            return input;
        }
        Matcher matcher = CONSECUTIVE_CHARACTERS_PATTERN.matcher(input);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, "");
        }
        matcher.appendTail(buffer);
        String result = buffer.toString();
        System.out.println("-> " + result);
        return result;
    }
}