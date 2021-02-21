package com.mprodev.medium;
/* Mirshod created on 1/25/2021 */

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        List<Integer> dp = new ArrayList<>(triangle.get(row - 1));
        System.out.println(dp);
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < row - i - 1; j++) {
                dp.set(j, Math.min(dp.get(j), dp.get(j + 1)) +
                        triangle.get(row - i - 2).get(j));
            }
        }
        return dp.get(0);
    }
}
