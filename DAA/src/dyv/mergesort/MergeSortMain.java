package dyv.mergesort;

import java.util.Scanner;

public class MergeSortMain {
    public static void main(String[] args){
        //n elements
        int n;
        int[] vector;

        Scanner sc =  new Scanner(System.in);

        n =  sc.nextInt();
        vector = new int[n];

        for(int i = 0; i < n; i++){
            vector[i] = sc.nextInt();
        }

        int[] resul =  divide(vector);
        for(int i : resul){
            System.out.print(i + " ");
        }
    }
    private static int[] divide(int[] v){
        if (v.length == 1){
            return v;
        }
        int half = v.length/2;
        int[] left = new int[half];
        int[] right;
        if((v.length % 2) == 0){
            right = new int[half];
        }else{
            right = new int[half+1];
        }
        for(int i = 0; i<left.length; i++){
            left[i] = v[i];
        }
        for(int i = 0; i< right.length; i++){
            right[i] = v[half+i];
        }

        int[] solL = divide(left);
        int[] solR = divide(right);
        int[] solution = combine(solL,solR);
        return solution;
    }

    private static int[] combine(int[] left, int[] right){
        int size = left.length + right.length;
        int[] solution = new int[size];
        //iterators
        int itL = 0;
        int itR = 0;
        int it = 0;
        while((itL < left.length)||(itR<right.length)){
            //in case both vectors still have elements
            if((itL < left.length)&&(itR<right.length)){
                if(left[itL]<=right[itR]){
                    solution[it] = left[itL];
                    it++;
                    itL++;
                }else{
                    solution[it] = right[itR];
                    it++;
                    itR++;
                }
            }else if(itL == left.length){
                solution[it] = right[itR];
                it++;
                itR++;
            }else{
                solution[it] = left[itL];
                it++;
                itL++;
            }
        }
        return solution;
    }
}
