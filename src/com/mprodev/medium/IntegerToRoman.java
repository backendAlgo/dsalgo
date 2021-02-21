package com.mprodev.medium;
/* Mirshod created on 2/10/2021 */

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        Object[][] symbols = new Object[][] {
                {1, 'I'},
                {4, "IV"},
                {5, 'V'},
                {9, "IX"},
                {10, 'X'},
                {40, "XL"},
                {50, 'L'},
                {90, "XC"},
                {100, 'C'},
                {400, "CD"},
                {500, 'D'},
                {900, "CM"},
                {1000, 'M'}
        };
        StringBuilder ans = new StringBuilder();
        int first;
        String second;
        while (num != 0) {
            for (int i = symbols.length - 1; i >= 0; --i) {
                first = (int) symbols[i][0];
                second = (String) symbols[i][1];
                if (num >= first) {
                    num-= first;
                    ans.append(second);
                }
            }
        }
        return ans.toString();
    }
}
