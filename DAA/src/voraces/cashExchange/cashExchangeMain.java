package voraces.cashExchange;

import java.util.Scanner;

public class cashExchangeMain {
    public static void main(String[] args){
        // M = {500, 200, 100, 50, 20, 10, 5, 2, 1}
        int[] M = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] coins = new int[9];
        int casos;
        int[] vuelta;

        Scanner sc = new Scanner(System.in);
        casos = sc.nextInt();
        for(int i =0; i<coins.length; i++){
            coins[i] = sc.nextInt();
        }
        vuelta = new int[casos];

        for(int i=0; i<casos; i++){
            vuelta[i]=sc.nextInt();
        }

        for(int cambio : vuelta){
            int[]coinsAux = coins.clone();
            int it = 0;
            int resul = 0;
            while(it <9 && cambio > 0){
                if(coinsAux[it]>0 && (cambio - M[it]>=0)){
                    cambio -= M[it];
                    coinsAux[it]--;
                    resul++;
                }else{
                    it++;
                }
            }
            if(cambio == 0){
                System.out.println(resul);
            }else{
                System.out.println(-1);
            }
        }
    }
    /*
    1 10 1 1 0 1 0 0 30

     */
}
