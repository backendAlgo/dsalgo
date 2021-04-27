package com.mprodev.codeforces.c690;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * mprodev for codeforces
 */

public class F {
    static class Segment {
        int l, r;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
//using fedwick tree
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt();
            var a = new Segment[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Segment(fs.nextInt(), fs.nextInt());
            }
            //compressing
            var xs = new TreeSet<Integer>();
            for (Segment s : a) {
                xs.add(s.l);
                xs.add(s.r);
            }
            var compress = new HashMap<Integer, Integer>();
            for (int i : xs) compress.put(i, compress.size());
            for (Segment s : a) {
                s.l = compress.get(s.l);
                s.r = compress.get(s.r);
            }
            //end of compressing
            BIT bit = new BIT(compress.size()+1);
            Event[] events = new Event[2 * n];
            int i = 0;
            for (Segment s : a) {
                events[i++] = new Event(s.l, s.r, true);
                events[i++] = new Event(s.l, s.r, false);
            }
            Arrays.sort(events);
            int ans = 0;
            for (Event e : events) {
                if (e.start) {
                    bit.update(e.r, 1);
                } else {
                    ans = Math.max(ans, bit.query(e.l, compress.size()));
                }
            }
            System.out.println(n - ans);
        }

    }

    static class Event implements Comparable<Event> {
        int l, r;
        boolean start;

        public Event(int l, int r, boolean start) {
            this.l = l;
            this.r = r;
            this.start = start;
        }

        int x() {
            if (start) return l;
            return r;
        }

        @Override
        public int compareTo(Event o) {
            // if coordinates not equal than just compare it
            // else both of events beginning than return 0 means they are equal
            // if current event is beginning but other event is end than return -1
            //means current event is smaller than other
            //else condition return 1
            if (x() != o.x())
                return Integer.compare(x(), o.x());
            if (start == o.start) return 0;
            if (start) return -1;
            return 1;
        }
    }

    static class BIT {
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


    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }


}
