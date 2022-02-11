package ru.rblednov.leetcode.strings;

import java.nio.charset.StandardCharsets;

public class FindDiff {
    public static char findTheDifference(String s, String t) {
        byte[] arr = (s + t).getBytes(StandardCharsets.UTF_8);
        int result = 0;
        for (byte b : arr) {
            result = b ^ result;
        }

        return Character.valueOf((char) result);
    }
}
