package com.mprodev.easy;
/* Mirshod created on 2/6/2021 */

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int begin = 0;
        int end = S.length()-1;
        char[] array = S.toCharArray();
        while (begin < end) {
            if (!Character.isLetter(array[begin])) begin++;
            else if (!Character.isLetter(array[end])) end--;
            else {
                char temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
                begin++;
                end--;
            }
        }
        return String.valueOf(array);
    }
}
