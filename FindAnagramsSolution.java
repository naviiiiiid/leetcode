package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAnagramsSolution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        int[] chP = new int[26];
        for (char c : p.toCharArray()) chP[c - 'a']++;

        for (int indexS = 0; indexS < s.length(); indexS++) {
            if (indexS + p.length() > s.length())
                break;
            String substringS = s.substring(indexS, indexS + p.length());

            int[] chS = new int[26];
            for (char c : substringS.toCharArray()) chS[c - 'a']++;

            if (Arrays.equals(chS, chP))
                list.add(indexS);
        }
        return list;
    }
}
