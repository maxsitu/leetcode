package com.leetcode.oj.medium;

import java.util.*;

/**
 * Created by appleowner on 3/22/15.
 */
public class WordLadder {
//    public Map<String,String> map = new HashMap<String, String>();

    public static void main(String[] args) {
        String start = "qa";
        String end = "sq";
        String[] strArr = new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm",
                "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
                "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb",
                "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi",
                "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am",
                "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        Set<String> dict = new HashSet<String>();
        for (String str : strArr) {
            dict.add(str);
        }
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength(start, end, dict));

/*        String curr = end;
        while (curr!=null){
            System.out.print(curr);
            curr = wl.map.get(curr);
            if(curr!=null){
                System.out.print(" <- ");
            }
        }*/
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        Map<String, Integer> dis = new HashMap<String, Integer>();
        Vector<String> vector = new Vector<String>();
        dis.put(start, 1);
        vector.add(start);
        boolean loop = true;

        while (!vector.isEmpty() && loop) {
            String word = vector.get(0);
            vector.remove(0);
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    char[] newWordArr = word.toCharArray();
                    newWordArr[i] = (char) ('a' + j);
                    String newWord = new String(newWordArr);
                    if (dict.contains(newWord) && !dis.containsKey(newWord)) {
//                        map.put(newWord, word);
                        dis.put(newWord, dis.get(word) + 1);
                        vector.add(newWord);
                        if (newWord.equals(end)) {
                            loop = false;
                            break;
                        }
                    }
                }
            }
        }
        if (!dis.containsKey(end)) return 0;
        return dis.get(end);
    }
}
