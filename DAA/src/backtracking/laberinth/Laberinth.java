package backtracking.laberinth;

import java.util.Scanner;

public class Laberinth {
    final int ARRIBA = 10;
    final int DERECHA = 11;
    final int ABAJO = 12;
    final int IZQUIERDA = 13;

    private static int size;
    private static int[][] lab;
    private static int minLength;

    private static int path;
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        lab = new int[size][size];
        minLength = size*size+1; //Longitud maxima que podria llegar a tener el camino +1 para confirmar cuando no haya buenos
        path = 1;

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                lab[i][j] = sc.nextInt();
            }
        }
        if(lab[0][0] == -1 || lab[size-1][size-1]== -1){
            System.out.println("SIN SOLUCION");
            System.exit(0);
        }

        findPath(0,0);

        if(minLength == size*size+1){
            System.out.println("SIN SOLUCION");
        }else{
            System.out.println(minLength);
        }

    }

    private static void findPath(int row, int col){
        //Checkea si es solucion
        if(row == size-1 && col == size-1){
            if(path < minLength){
                minLength = path;
            }
            return;
        }

        //Marcamos como visitada la casilla
        lab[row][col] = 1;
        path++;

        /*Redirecciones del camino */

        //Derecha
        if (checkViable(row+1, col)){
            findPath(row+1, col);
        }
        //Abajo
        if (checkViable(row,col+1)){
            findPath(row, col+1);
        }
        //Izquierda
        if (checkViable(row-1, col)){
            findPath(row-1,col);
        }
        //Arriba
        if (checkViable(row,col-1)){
            findPath(row, col-1);
        }

        lab[row][col] = 0;
        path--;

    }

    private static boolean checkViable(int row, int col){
        if(row >= 0 && row < size && col >= 0 && col < size){
            return lab[row][col] == 0;
        }
        return false;
    }
}
