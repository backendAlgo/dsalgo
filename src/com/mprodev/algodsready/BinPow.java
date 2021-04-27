package com.mprodev.algodsready;
/* Mirshod created on 2/26/2021 */


public class BinPow {
    public static final long MOD = 1_000_000_007;
    public static long binPow(long a, long pow) {
        if (pow == 0) return 1;
        long half = binPow(a, pow / 2);
        if (pow % 2 == 1) return mul(half, mul(half, a));
        else return mul(half, half);
    }
    public static long mul(long a, long b) {
        return a * b % MOD;
    }
    public static long modInv(long a) {
        return binPow(a, MOD - 2);
    }
    public static void main(String[] args) {
        System.out.println(binPow(2,10));
    }
}
