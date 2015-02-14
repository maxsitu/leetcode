package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 2/14/15.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        int size = 0, startIndex = 0;
        for(int i=0;i<num.length;i++){
            startIndex = (i>=1&&num[i]==num[i-1])?size:0;
            size = ret.size();
            for(int j=startIndex;j<size;j++){
                List<Integer> temp = ret.get(j);
                temp = new ArrayList<Integer>(temp);
                temp.add(num[i]);
                ret.add(temp);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new SubsetsII().subsetsWithDup(new int[]{1,2,2});
        for (List<Integer> l:result){
            for (int i:l){
                System.out.format("%3d", i);
            }
            System.out.println();
        }
    }
}
