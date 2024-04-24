package w.connect;

import java.util.regex.Pattern;

/**
 * Abstract class for processing consecutive characters in a string.
 */
public abstract class AbstractConsecutiveCharactersProcessor implements StringProcessor {

    protected static final Pattern CONSECUTIVE_CHARACTERS_PATTERN = Pattern.compile("(.)\\1{2,}");

    protected static final Pattern ALPHABET_CHARACTERS_PATTERN = Pattern.compile("^[a-z]+$");
    
    @Override
    public boolean shouldProcess(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }
        if(!ALPHABET_CHARACTERS_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("Input string must only contain alphabetic characters.");
        }
        return CONSECUTIVE_CHARACTERS_PATTERN.matcher(input).find();
    }
}
