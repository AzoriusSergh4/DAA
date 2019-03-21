package voraces;

        import java.util.ArrayList;
        import java.util.Scanner;

public class Activities {
    public static void main(String [] args){
        int casos;
        int actividades;

        Scanner sc = new Scanner(System.in);

        casos = sc.nextInt();
        //Vector de ArrayLists de los casos(2 por caso)
        ArrayList<Integer>[] listas = new ArrayList[casos*2];

        //Inicialización de los ArrayList del vector
        for(int i=0; i<listas.length; i++){
            listas[i] = new ArrayList<>();
        }

        for(int i = 0; i<casos; i++){
            actividades = sc.nextInt();
            for(int j = 0; j<actividades; j++){
                listas[i*2].add(sc.nextInt());
                listas[(i*2)+1].add(sc.nextInt());
            }

        }

    }
}
