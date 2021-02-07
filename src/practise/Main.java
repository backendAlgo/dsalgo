package practise;
/* Mirshod created on 2/1/2021 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(45,65);
        map.put(5,3);
        map.put(75,7);
        map.put(85,65);
        map.put(41,68);
        map.put(2,74);
        map.put(74,42);
        map.put(38,63);
        map.merge(23, 98, (v1, v2) -> {
           return v1 + v2;
        });
        map.merge(2, 78, (v1, v2) -> {
           return ++v1;
        });

        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        System.out.println("\n\n");
        List<Integer> list = new ArrayList<>(1);
        list.add(45);
        list.add(68);
    }
}
