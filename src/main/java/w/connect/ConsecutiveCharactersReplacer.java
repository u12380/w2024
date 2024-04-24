package w.connect;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;

/**
 * ConsecutiveCharacterReplacer replaces consecutive characters with a single character.
 */
public class ConsecutiveCharactersReplacer extends AbstractConsecutiveCharactersProcessor {

    @Override
    public String process(String input) {
        if (!shouldProcess(input)) {
            return input;
        }
        Set<String> replaceCharSet = new TreeSet();
        Matcher matcher = CONSECUTIVE_CHARACTERS_PATTERN.matcher(input);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String currentChar = matcher.group(1);
            replaceCharSet.add(currentChar);
            matcher.appendReplacement(buffer, getPreChar(currentChar));
        }
        matcher.appendTail(buffer);
        String result = buffer.toString();
        System.out.println("-> " + result + ", " + composeMessage(replaceCharSet));
        return result;
    }

    private String getPreChar(String currentChar) {
        if ("a".equals(currentChar)) {
            return "";
        }
        return String.valueOf((char) (currentChar.charAt(0) - 1));
    }

    private String composeMessage(Set<String> replaceCharSet) {
        StringBuilder sb = new StringBuilder();
        replaceCharSet.forEach(
                c -> {
                    if (sb.length() != 0) {
                        sb.append(" and ");
                    }
                    if ("a".equals(c)) {
                        sb.append("aaa is removed");
                    } else {
                        sb.append(c.repeat(3)).append(" is replaced by " + (char) (c.charAt(0) - 1));
                    }
                }
        );
        return sb.toString();
    }
}