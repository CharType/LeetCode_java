package com.cq.source.sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSequence();
        for (Integer step : stepSequence) {
            sort(step);
        }
    }


    /**
     * 分词多少列进行排序
     *
     * @param step
     */
    private void sort(int step) {
        for (int col = 0; col < step; col++) {

            for (int begin = col + step; begin < array.length; begin += step) {
                int oldbegin = begin;
                while (oldbegin > col && cmp(oldbegin, oldbegin - step) < 0) {
                    swap(oldbegin, oldbegin - step);
                    oldbegin -= step;
                }
            }
        }
    }

    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;
        while ((step = step >> 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }
}
