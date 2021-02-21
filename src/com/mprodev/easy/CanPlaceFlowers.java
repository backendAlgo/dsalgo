package com.mprodev.easy;
/* Mirshod created on 2/7/2021 */

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int begin = -2;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                n -= (i - begin - 2) / 2;
                begin = i;
            }
        }
        n -= (flowerbed.length - begin - 1) / 2;
        return n <= 0;
    }
}
