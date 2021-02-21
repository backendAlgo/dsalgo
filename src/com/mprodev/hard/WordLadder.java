package com.mprodev.hard;
/* Mirshod created on 2/10/2021 */

import com.mprodev.medium.KthLargestElementInArray;

import java.util.List;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        System.out.println(wordList.get(5));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new WordLadder().ladderLength("hit","cog",
                        List.of("hot", "dot", "dog", "lot", "log", "cog"))
        );
    }
}
