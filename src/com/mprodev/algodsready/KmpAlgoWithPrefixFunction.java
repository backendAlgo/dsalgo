package com.mprodev.algodsready;
/* Mirshod created on 1/29/2021 */

public class KmpAlgoWithPrefixFunction {
    //kmp prefix function
    public int[] prefixFunction(String a) {
        int n = a.length();
        int[] ans = new int[n];
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            int j = ans[i - 1];
            while (j > 0 && a.charAt(i) != a.charAt(j))
                j = ans[j - 1];
            if (a.charAt(i) == a.charAt(j))
                j++;
            ans[i] = j;
        }
        return ans;
    }

    public void kmpSeach(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        int[] lps = prefixFunction(pat);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KmpAlgoWithPrefixFunction().kmpSeach(pat, txt);
    }
}
