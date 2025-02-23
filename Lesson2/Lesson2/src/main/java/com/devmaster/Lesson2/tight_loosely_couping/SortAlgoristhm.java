package com.devmaster.Lesson2.tight_loosely_couping;

import java.util.Arrays;

public interface SortAlgoristhm {
    void sort(int[] arr);
}
class LooselyBubbleSortAlgoristhn implements SortAlgoristhm {
    @Override
    public void sort(int[] arr) {
        System.out.println("Sorted ... ");
        Arrays.stream(arr).sorted().forEach(System.out::println);
    }

}
