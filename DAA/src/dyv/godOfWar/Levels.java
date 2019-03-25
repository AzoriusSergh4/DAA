package dyv.godOfWar;

import java.util.Scanner;

public class Levels {
    public static void main(String[] args){
        int casos;
        int[] niveles;
        int numNiveles;
        int[] jugadores;

        Scanner sc = new Scanner(System.in);

        numNiveles = sc.nextInt();
        niveles = new int[numNiveles];
        for(int i = 0; i < numNiveles; i++){
            niveles[i] = sc.nextInt();
        }
        casos = sc.nextInt();
        jugadores = new int[casos];
        for(int i = 0; i < casos; i++){
            jugadores[i] = sc.nextInt();
        }

        for(int i = 0; i < jugadores.length; i++){
            Par resul = findLevels(niveles, jugadores[i]);
            String left;
            String right;
            if(resul.getLeft() == -1){
                left = "X";
            }else{
                left = Integer.toString(resul.getLeft());
            }
            if(resul.getRight() == -1){
                right = "X";
            }else{
                right = Integer.toString(resul.getRight());
            }
            System.out.println(left + " " + right);
        }

    }

    private static Par findLevels(int[]niveles, int nivel){
        Par resul;
        if(niveles.length==1){
            if(niveles[0] < nivel){
                resul = new Par(niveles[0], -1);
            }else{
                resul = new Par(-1, niveles[0]);
            }
            return resul;
        }
        int mitad = niveles.length/2;
        int[] izq = new int[mitad];
        int[] der;
        if((niveles.length % 2) == 0){
            der = new int[mitad];
        }else{
            der = new int[mitad+1];
        }
        for(int i = 0; i < izq.length; i++){
            izq[i] = niveles[i];
        }
        for(int i = 0; i < der.length; i++){
            der[i] = niveles[mitad+i];
        }
        int nivelI = izq[izq.length-1];
        int nivelD = der[0];
        if(nivel > nivelI && nivel < nivelD){
            resul = new Par(nivelI, nivelD);
        }else if(nivel > nivelD){
            resul = findLevels(der, nivel);
        }else if(nivel < nivelI){
            resul = findLevels(izq, nivel);
        }else if(nivel == nivelD){
            if(der.length==1){
                resul = new Par(nivelI,-1);
            }else{
                resul = new Par(nivelI, der[1]);
            }
        }else{
            if(izq.length==1){
                resul = new Par(-1, nivelD);
            }else{
                resul = new Par(izq[izq.length-2],nivelD);
            }
        }
        return resul;
    }

    private static class Par {
        private int left;
        private int right;
        private Par(int left, int right){
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }
    // 11 22 30 35 49 54 68 74 75 97
}
