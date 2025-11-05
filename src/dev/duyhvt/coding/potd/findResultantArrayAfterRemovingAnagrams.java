package dev.duyhvt.coding.potd;

import java.util.*;

public class findResultantArrayAfterRemovingAnagrams {
    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    private static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";
        for (String word : words) {
            String curr = sortString(word);
            if (!curr.equals(prev)) {
                prev = curr;
                result.add(word);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[] {"abba","baba","bbaa","cd","cd"}));
        System.out.println(removeAnagrams(new String[] {"a","b","c","d","e"}));
    }
}
