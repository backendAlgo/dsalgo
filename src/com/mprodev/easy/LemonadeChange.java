package com.mprodev.easy;
/* Mirshod created on 2/3/2021 */

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        //0->5, 1->10
        int[] money = new int[2];
        for (int e : bills) {
            if (e == 5) {
                money[0]++;
            } else if (e == 10) {
                if (money[0] > 0) {
                    money[0]--;
                    money[1]++;
                } else {
                    return false;
                }
            } else {
                if (money[1] > 0 && money[0] > 0) {
                    money[0]--;
                    money[1]--;
                } else if (money[0] > 3) {
                    money[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
