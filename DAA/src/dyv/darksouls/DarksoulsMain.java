package dyv.darksouls;

import java.util.Scanner;

public class DarksoulsMain {
    public static void main(String[] args){
        int nWaves;
        int[] waves;
        int cases;
        int[] levels;
        Scanner sc = new Scanner(System.in);

        nWaves = sc.nextInt();
        waves =  new int[nWaves];

        for(int i = 0; i < nWaves; i++){
            waves[i] = sc.nextInt();
        }
        cases =  sc.nextInt();
        levels = new int[cases];

        for(int i = 0; i < cases; i++){
            levels[i] = sc.nextInt();
        }

        for(int i = 0; i< levels.length; i++){
            int position = findWave(waves, levels[i], 0);
            int points = 0;
            if (position != -1) {
                for (int j = 0; j <= position; j++) {
                    points += waves[j];
                }
            }
            System.out.println(position+1 + " " + points);
        }
    }

    private static int findWave(int[] waves, int level, int start){
        int solution;
        if(waves.length == 1){
            if(level < waves[0]) {
                return -1;
            }else{
                return start;
            }
        }
        int half  = waves.length/2;
        int[] left;
        int[] right;
        left =  new int[half];
        if((waves.length%2)==0){
            right = new int[half];
        }else{
            right = new int[half+1];
        }

        for(int i = 0; i< left.length; i++){
            left[i] = waves[i];
        }
        for(int i = 0; i<right.length; i++){
            right[i] = waves[half+i];
        }

        int levelI = left[left.length-1];
        int levelR =  right[0];

        if((level >= levelI)&&(level<levelR)){
            solution = start+half-1;
        }else if(level < levelI){
            solution = findWave(left, level, start);
        }else{
            solution = findWave(right, level, start+half);
        }
        return solution;
    }
}
//1 2 3 4 5 6 7
