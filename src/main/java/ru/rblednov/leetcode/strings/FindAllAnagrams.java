package ru.rblednov.leetcode.strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//"dinitrophenylhydrazinetrinitrophenylmethylnitramine"
//"trinitrophenylmethylnitramine"
//
public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "azaz";
        String p = "az";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        byte[] sBytes = s.getBytes();
        byte[] pBytes = p.getBytes();
        int[] pHash = hash(pBytes);
        for (int i = 0; i < sBytes.length; i++) {
            if (i + pBytes.length > sBytes.length) {
                break;
            }
            if (isAnogramma(i, sBytes, pHash, pBytes.length)) {
                list.add(i);
            }
        }
        return list;
    }

    private static int[] hash(byte[] pBytes) {
        int[] response = new int[256];
        for (int i = 0; i < pBytes.length; i++) {
            response[pBytes[i]]++;
        }
        return response;
    }

    private static boolean isAnogramma(int i, byte[] sBytes, int[] pHash, int length) {
        int[] tmpPHash = Arrays.copyOf(pHash,pHash.length);
        for (int j = i; j < i + length; j++) {
            tmpPHash[sBytes[j]] = tmpPHash[sBytes[j]]-1;
            if ( tmpPHash[sBytes[j]]<0){
                return false;
            }
        }
        return true;
    }
}
