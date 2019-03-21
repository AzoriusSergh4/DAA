package dyv.ejercicio1;

public class Main {
    public static void main(String[]args){
        int[] list = {-5, -2, 0, 5, 4, 8, 10};
        IndexAlgorithm i = new IndexAlgorithm();

        int resul = i.resolve(list,0);

        System.out.println(resul);
    }
}
