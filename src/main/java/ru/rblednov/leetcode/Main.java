package ru.rblednov.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public boolean checkInclusion(String s1, String s2) {
        byte[] s1b = s1.getBytes();
        byte[] s2b = s2.getBytes();
        Map<Integer, Integer> hashS1 = new HashMap();
        for (int i = 0; i < s1b.length; i++) {
            hashS1.put((int) s1b[i], hashS1.getOrDefault((int) s1b[i], 0) + 1);
        }
        for (int i = 0; i < s2b.length && i + s1b.length <= s2b.length; i++) {
            Map<Integer, Integer> hashS2 = new HashMap();
            for (int ii = i; ii < i + s1b.length; ii++) {
                hashS2.put((int) s2b[ii], hashS2.getOrDefault((int) s2b[ii], 0) + 1);
            }
            boolean response = true;
            for (Map.Entry<Integer, Integer> entry : hashS1.entrySet()) {
                if (!entry.getValue().equals(hashS2.get(entry.getKey()))) {
                    response = false;
                }
            }
            if (response) {
                return true;
            }
        }
        return false;
    }

    public static int strLength(String a, String b) {
        int response = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                response++;
            }
        }
        return response;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, Integer> len = new HashMap<>();
        len.put(beginWord, 0);
        queue.addLast(beginWord);
        while (true) {
            String currElem = queue.poll();
            if (currElem == null) {
                break;
            }
            wordList.remove(currElem);

            for (String elem : new LinkedList<>(wordList)) {
                if (strLength(currElem, elem) == 1) {
                    queue.add(elem);
                    wordList.remove(elem);
                    if (endWord.equals(elem)) {
                        return len.get(currElem) + 2;
                    }
                    len.put(elem, len.get(currElem) + 1);
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {

        System.out.println(Math.pow(2, 3));
        System.out.println(Integer.toBinaryString(3).getBytes());
        StringBuilder stringBuilder =  new StringBuilder();

//        ArrayList<String> list = new ArrayList<>();
//        list.add("hot");
//        list.add("dot");
//        list.add("dog");
//        list.add("lot");
//        list.add("log");
//        list.add("cog");
//
//        System.out.println(ladderLength(
//                "hit",
//                "cog",
//                list));
    }
}
