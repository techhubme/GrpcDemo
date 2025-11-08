package com.demo.grpcdemo.util;

import com.demo.grpcdemo.config.Constant;
import java.util.List;

/**
 * Text wrapper
 *
 * @author Ram Niwash
 */
public final class LineWrapper {

    private LineWrapper() {}

    /**
     * Wrap the lines in into border
     *
     * @param lines        List of String
     * @param enableHeader boolean if border should have header
     * @return String
     */
    public static String wrapInBorder(List<String> lines, boolean enableHeader) {
        StringBuilder wrappedTest = new StringBuilder();
        /* Find max line length */
        int maxLen = lines.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
        String border = "+" + "-".repeat(maxLen + 2) + "+";
        String formatPattern = "| %-" + maxLen + "s |\n";
        wrappedTest.append(border).append(Constant.NEW_LINE);
        int idx = 0;
        if (enableHeader) {
            wrappedTest.append(String.format(formatPattern, lines.getFirst()));
            wrappedTest.append(border).append(Constant.NEW_LINE);
            idx++;
        }
        for (; idx < lines.size(); idx++) {
            String line = lines.get(idx);
            String tempLine = String.format(formatPattern, line);
            wrappedTest.append(tempLine);
        }
        wrappedTest.append(border).append(Constant.NEW_LINE);
        return wrappedTest.toString();
    }
}
