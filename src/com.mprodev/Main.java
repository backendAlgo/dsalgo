package com.mprodev;

import com.company.dsalgo.easy.IntersectionOfTwoArrays;
import com.company.dsalgo.easy.IntersectionOfTwoArraysII;
import com.company.dsalgo.medium.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new MinimumHeightTree().findMinHeightTrees(4,
//                new int[][]{{1,0},{1,2},{1,3}}));
//        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(
//                new int[]{1, 2, 2, 1},
//                new int[]{2, 2}
//        )));
//        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(
//                new int[]{1, 2, 2, 1},
//                new int[]{2, 2}
//        )));
//        System.out.println(new WordLadder().ladderLength(
//                "hit",
//                "cog",
//                List.of("hot","dot","dog","lot","log","cog")
//        ));
//        assert new EggDroppingPuzzle().eggDrop(2,10) != 4 : "Wrong";
//        assert new EggDroppingPuzzle().eggDrop(3,5) != 3 : "Wrong";
//        assert !new CanJump().canJump(
//                new int[]{
//                        2, 3, 1, 1, 4
//                }
//        ) : "Wrong";
//        assert new Triangle().minimumTotal(
//                List.of(
//                        List.of(2),
//                        List.of(3,4),
//                        List.of(6,5,7),
//                        List.of(4,1,8,3)
//
//                )
//        ) != 11 : "Wrong";
//        System.out.println("Success");
        assert new CheckSubarraySum().checkSubarraySum(
                new int[] {23,2,4,6,7},
                6
        ) : "Wrong" ;
        System.out.println("Success");
    }
}
