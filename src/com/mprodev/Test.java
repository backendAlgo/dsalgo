package com.mprodev;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List list=new ArrayList(List.of("good", "better", "best",
                "best", "first", "last", "last", "last","good"));
        removeDuplicates(list);
    }
    public static void removeDuplicates(List list) {
        Optional.ofNullable(list).ifPresent(l->{
            for (int i=0;i<list.size();i++) {
                for (int j=i+1;j<list.size();j++) {
                    if (list.get(i).equals(list.get(j))) {
                        list.remove(j);
                    }
                }
            }
            System.out.println(list);
        });
    }
}
