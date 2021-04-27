package com.mprodev.algodsready;
/* Mirshod created on 2/28/2021 */

public class BIT {
    private final int N;
    private final int[] tree;

    public BIT(int N) {
        this.N = N;
        tree = new int[N + 1];
    }

    public void update(int i, int diff) {
        for (i++; i <= N; i += i & -i) {
            tree[i] += diff;
        }
//        or using java lowestBitOne
//        i++;
//        while (i <= N) {
//            tree[i] += val;
//            i += Integer.lowestOneBit(i);
//        }
    }

    public int read(int i) {
        int sum = 0;
        for (i++; i > 0; i -= i & -i)
            sum += tree[i];
        return sum;
    }

    // query sum of [l, r] both inclusive
    public int query(int l, int r) {
        return read(r) - read(l - 1);
    }

    public int genKth(int k) {
        if (k < 0)
            return -1;
        int i = 0;
        for (int pw = Integer.highestOneBit(N); pw > 0; pw >>= 1)
            if (i + pw <= N && tree[i + pw] <= k)
                k -= tree[i += pw];
        return i;
    }
}
