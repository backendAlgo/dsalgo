package com.mprodev.algodsready;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RabinKarpForCommonString {
    int n;//length of a
    int m;//length of b
    final int P = 109;
    final int MOD = (int) 1e9 + 9;
    final int PInv = BigInteger.valueOf(P)
            .modInverse(BigInteger.valueOf(MOD))
            .intValue();


    public int findLength(int[] a, int[] b) {
        n = a.length;
        m = b.length;
        int l = 0;
        int r = Math.min(n, m);
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(a, b, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
        // int[] arolling=rolling(a,3);
        // int[] brolling=rolling(b,3);
        // System.out.println(Arrays.toString(arolling));
        // System.out.println(Arrays.toString(brolling));

    }

    public boolean check(int[] a, int[] b, int possible) {
        int[] hashes = rolling(a, possible);
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        int i = 0;
        for (int h : rolling(a, possible)) {
            hashMap.computeIfAbsent(h, key -> new ArrayList<>()).add(i++);
        }
        int j = 0;
        for (int h : rolling(b, possible)) {
            for (int index : hashMap.getOrDefault(h, new ArrayList<>())) {
                if (arrayCheck(a, index, index + possible, b, j, j + possible)) {
                    return true;
                }
            }
            j++;
        }
        return false;
    }

    public boolean arrayCheck(int[] a, int f1, int s1, int[] b, int f2, int s2) {
        boolean equal = true;
        for (int i = f1, j = f2; i < s1 && j < s2 && equal; i++, j++) {
            equal = equal && (a[i] == b[j]);
        }
        return equal;
    }

    public int[] rolling(int[] a, int len) {
        int n = a.length;
        int[] ans = new int[n - len + 1];
        long h = 0;
        long power = 1;
        if (len == 0) return ans;
        for (int i = 0; i < n; i++) {
            h = (h + a[i] * power) % MOD;
            if (i < len - 1) {
                power = power * P % MOD;
            } else {
                ans[i - len + 1] = (int) h;
                h = (h + MOD - a[i - len + 1]) * PInv % MOD;
            }
        }
        return ans;
    }
}
