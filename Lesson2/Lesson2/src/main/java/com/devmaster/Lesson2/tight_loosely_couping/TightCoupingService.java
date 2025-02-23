package com.devmaster.Lesson2.tight_loosely_couping;

import java.util.Arrays;

//Tight couping
class BubbleSortAlgoristhn{
    public void sort(int[] arr){
        System.out.println("Sắp xếp theo giải thuật BubbleSort");
        int n=arr.length;
        boolean swapper;
        for(int i=0;i<n-1;i++){
            swapper=false;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapper=true;

                }
            }
            if(!swapper){
                break;
            }
        }
    }
}
public class TightCoupingService {
    private BubbleSortAlgoristhn bubbleSortAlgoristhn = new BubbleSortAlgoristhn();
    public TightCoupingService(){}
    public TightCoupingService(BubbleSortAlgoristhn bubbleSortAlgoristhn){
        this.bubbleSortAlgoristhn=bubbleSortAlgoristhn;
    }
    public void complexBussinessSort(int[] arr){
        bubbleSortAlgoristhn.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        TightCoupingService tCoupingService = new TightCoupingService();
        tCoupingService.complexBussinessSort(new int[]{11,22,10,6,55});
    }
}
