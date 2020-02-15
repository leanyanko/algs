package com.company;

import java.util.ArrayList;
import java.util.List;

public class Pyramide {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        List<Integer> item = new ArrayList<>();
        item.add(1);
        result.add(item);

        for (int i = 1; i < numRows; i++) {
            List<Integer> nextItem = new ArrayList<>();
            //  nextItem.add(1);
            int left = 0;
            for (int val: item) {
                nextItem.add(left + val);
                left = val;
            }

            nextItem.add(1);
            result.add(nextItem);
            item = nextItem;
        }

        return result;
    }
}
