package com.devmaster.Lesson2.tight_loosely_couping;

public class LooselyCoupledService {
    private SortAlgoristhm sortAlgoristhm;
    public LooselyCoupledService() {}
    public LooselyCoupledService(SortAlgoristhm sortAlgoristhm) {
        this.sortAlgoristhm = sortAlgoristhm;
    }
    public void complexBussiness(int[] array) {
        sortAlgoristhm.sort(array);
    }
    public static void main(String[] args) {
        LooselyCoupledService sorter = new LooselyCoupledService(new LooselyBubbleSortAlgoristhn());
        sorter.complexBussiness(new int[]{22,1,5,15,11,34,12});
    }
}
