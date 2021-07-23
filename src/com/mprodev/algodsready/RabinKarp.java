package com.mprodev.algodsready;

public class RabinKarp {
    public static boolean rabinKarp(String word, String pattern) {
        /**
         * Should be prime number more than all possible characters of string
         * in this case 31 because alphabet is 26
         */
        final int BASE = 31;
        final int MOD = (int) 1e9 + 7;
        int W = word.length();
        int P = pattern.length();
        long[] pPow = new long[Math.max(W, P)];
        pPow[0] = 1;
        for (int i = 1; i < pPow.length; i++) {
            pPow[i] = pPow[i - 1] * BASE % MOD;
        }
        long[] hashes = new long[W + 1];
        for (int i = 0; i < W; i++) {
            hashes[i + 1] = (hashes[i] + (word.charAt(i) - 'a' + 1) * pPow[i]) % MOD;
        }
        long hashToFind = 0;
        for (int i = 0; i < P; i++) {
            hashToFind = (hashToFind + (pattern.charAt(i) - 'a' + 1) * pPow[i]) % MOD;
        }
        for (int i = 0; i + P - 1 < W; i++) {
            long currHash = (hashes[i + P] + MOD - hashes[i]) % MOD;
            if (currHash == (hashToFind * pPow[i]) % MOD)
                return true;
        }
        return false;
    }
}
