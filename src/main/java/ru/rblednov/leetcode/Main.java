//package ru.rblednov.leetcode;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.TreeSet;
//
//public class Main {
//    public boolean checkInclusion(String s1, String s2) {
//        byte[] s1b = s1.getBytes();
//        byte[] s2b = s2.getBytes();
//        Map<Integer, Integer> hashS1 = new HashMap();
//        for (int i = 0; i < s1b.length; i++) {
//            hashS1.put((int) s1b[i], hashS1.getOrDefault((int) s1b[i], 0) + 1);
//        }
//        for (int i = 0; i < s2b.length && i + s1b.length <= s2b.length; i++) {
//            Map<Integer, Integer> hashS2 = new HashMap();
//            for (int ii = i; ii < i + s1b.length; ii++) {
//                hashS2.put((int) s2b[ii], hashS2.getOrDefault((int) s2b[ii], 0) + 1);
//            }
//            boolean response = true;
//            for (Map.Entry<Integer, Integer> entry : hashS1.entrySet()) {
//                if (!entry.getValue().equals(hashS2.get(entry.getKey()))) {
//                    response = false;
//                }
//            }
//            if (response) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static int strLength(String a, String b) {
//        int response = 0;
//        for (int i = 0; i < a.length(); i++) {
//            if (a.charAt(i) != b.charAt(i)) {
//                response++;
//            }
//        }
//        return response;
//    }
//
//    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//        LinkedList<String> queue = new LinkedList<>();
//        HashMap<String, Integer> len = new HashMap<>();
//        len.put(beginWord, 0);
//        queue.addLast(beginWord);
//        while (true) {
//            String currElem = queue.poll();
//            if (currElem == null) {
//                break;
//            }
//            wordList.remove(currElem);
//
//            for (String elem : new LinkedList<>(wordList)) {
//                if (strLength(currElem, elem) == 1) {
//                    queue.add(elem);
//                    wordList.remove(elem);
//                    if (endWord.equals(elem)) {
//                        return len.get(currElem) + 2;
//                    }
//                    len.put(elem, len.get(currElem) + 1);
//                }
//
//            }
//        }
//        return 0;
//    }
//
//    public static String removeKdigits(String num, int k) {
//        for (int i = 0; i < k; i++) {
//            int prew = -1;
//            for (int j = 0; j < num.length(); j++) {
//                int currVal = Integer.valueOf(num.charAt(j)) - Integer.valueOf('0');
//                if (currVal < prew) {
//                    num = num.replaceFirst(String.valueOf(prew), "");
//                    break;
//                }
//                if (j == num.length() - 1) {
//                    num = num.replaceFirst(String.valueOf(currVal), "");
//                }
//                prew = currVal;
//            }
//        }
//        while (!num.isEmpty() && num.charAt(0) == '0') {
//            num = num.replaceFirst("0", "");
//        }
//        if (num.isEmpty()) {
//            return "0";
//        }
//        return num;
//    }
//
//    public static boolean isEven(int a) {
//        return a % 2 == 0;
//    }
//
//    public static boolean isOdd(int a) {
//        return a % 2 == 1;
//    }
//
//    public static int minimumDeviation(int[] nums) {
//        //TreeSet Obig(NlogN)
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        for (int num : nums) {
//            if (isOdd(num)) {
//                num = num * 2;
//            }
//            treeSet.add(num);
//        }
//        int dev = Integer.MAX_VALUE;
//        while (true) {
//            int min = treeSet.first();
//            int max = treeSet.last();
//            int curDev = max - min;
//            if (curDev < dev) {
//                dev = curDev;
//            }
//            TreeMap treeMap = new TreeMap();
//            treeMap.pollFirstEntry();
//            if (isEven(max)) {
//                treeSet.add(treeSet.pollLast() / 2);
//            } else {
//                return dev;
//            }
//        }
//
//    }
//
//    public static int removeCoveredIntervals(int[][] intervals) {
//        Arrays.sort(intervals, (a,b)-> {
//            if(a[0]==b[0]){
//                return b[1]-a[1];
//            }else{
//                return a[0]-b[0];
//            }
//        });
//        int response  = intervals.length;
//        int prew = -1;
//        for(int[] interval :intervals){
//            if(prew>=interval[1]){
//                --response;
//            }else{
//                prew = interval[1];
//            }
//        }
//        return response;
//    }
//
//    public static void main(String[] args) {
//        "a".to
//        System.out.println(Arrays.stream(new int[][]{{1,2,3},{3,2,2}}).map(arr->Arrays.stream(arr).sum()).max(Integer::compareTo).orElse(0));
////        System.out.println(removeCoveredIntervals(new int[][]{{1, 9}, {1, 2}, {1, 3}, {1, 4}, {2, 11}, {4, 8}, {2, 10}, {3, 10}, {3, 11}}));
////315
////        System.out.println(minimumDeviation(new int[]{
////                1, 2, 3, 4}));
//
//        /*[1,2,3,4]
//[399, 908, 648, 357, 693, 502, 331, 649, 596, 698]
//[1,2,2]
//[1,2]
//[123,124,1233,111]
//[610,778,846,733,395]
//[10,4,3]
//[4,1,5,20,3]
//*/
////                                                        454                             344
////        System.out.println(Math.pow(2, 3));
////        System.out.println(Integer.toBinaryString(3).getBytes());
////        StringBuilder stringBuilder =  new StringBuilder();
//
////        ArrayList<String> list = new ArrayList<>();
////        list.add("hot");
////        list.add("dot");
////        list.add("dog");
////        list.add("lot");
////        list.add("log");
////        list.add("cog");
////
////        System.out.println(ladderLength(
////                "hit",
////                "cog",
////                list));
//    }
//}
