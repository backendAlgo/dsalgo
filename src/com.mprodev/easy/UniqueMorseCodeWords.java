package com.mprodev.easy;
/* Mirshod created on 1/29/2021 */

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."
        };
        Set<String> container = new HashSet<>();
        StringBuilder str = new StringBuilder();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                str.append(morse[c - 'a']);
            }
            container.add(str.toString());
            str.setLength(0);
        }
        return container.size();
    }
}
