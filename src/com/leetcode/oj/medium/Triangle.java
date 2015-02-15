package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 2/15/15.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int[] arr = new int[triangle.get(triangle.size() - 1).size()];
        Arrays.fill(arr, 0);
        for (List<Integer> row : triangle) {

            for (int i = row.size() - 1; i > 0; i--) {
                if (i == row.size() - 1) arr[i] = arr[i - 1] + row.get(i);
                else
                    arr[i] = Math.min(arr[i - 1], arr[i]) + row.get(i);
            }
            arr[0] = arr[0] + row.get(0);
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(6, 5, 7));
        input.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(new Triangle().minimumTotal(input));
    }
}
