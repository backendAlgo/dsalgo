package com.mprodev.algodsready;
/* Mirshod created on 2/26/2021 */

public class Combinatorics {
    public static long[] facts = new long[300_000];
    public static void preCompute() {
        facts[0] = 1;
        for (int i = 1; i < facts.length; i++)
            facts[i] = BinPow.mul(facts[i-1], i);
    }

    public static void main(String[] args) {
        preCompute();
        System.out.println(facts[50]);
    }
}
