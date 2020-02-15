package wwcnyc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayPairSum {
   // int arr[];
   Map <Integer, Integer> map;
   int [] input;
   int k;

   public ArrayPairSum(int [] input, int k ) {
       map = new HashMap<Integer, Integer>();
       this.input = input;
       this.k = k;
   }

    public void sumPairs (){
        Arrays.sort(input);
        int i = 0;
        int j = input.length - 1;
        while(input[j] > k) j--;

        findSum(input, i, j, k);

        System.out.print(map.toString());
    }

    private  void findSum(int arr[], int top, int bottom, int k){
        if (top == bottom || top > bottom) return;

        if (arr[top] + arr[bottom] == k) {
            if (!map.containsKey(arr[top]) && !map.containsKey(arr[bottom]))
                map.put(arr[bottom], arr[top]);
        }
           // System.out.println("(" + arr[top] + " + " + arr[bottom] + ")" );

        findSum(arr, top + 1, bottom, k);
        findSum(arr, top, bottom - 1, k);

    }
    public static void main(String[] args) {
        int arr[]  = {3, 8, 6, 11, 94, 1};
        ArrayPairSum a = new ArrayPairSum(arr, 9);
        a.sumPairs();
    }
}
