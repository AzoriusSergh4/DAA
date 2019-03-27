package voraces.darksouls;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Weight {
    public static void main(String[] args){
        int nPieces;
        int maxWeight;
        String armor;
        List<Piece> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        nPieces = sc.nextInt();
        maxWeight = sc.nextInt();

        float maxW = 0;
        armor = sc.next();
        switch(armor){
            case "ligero":
                maxW = (float)maxWeight/2;
                break;
            case "medio":
                maxW = (float)maxWeight*3/4;
                break;
            case "pesado":
                maxW = (float)maxWeight;
                break;
            default:
                System.err.println("Error: elija entre 'ligero', 'medio' o 'pesado'");
                System.exit(1);
        }


        for(int i = 0; i < nPieces; i++){
            list.add(new Piece(sc.next(), sc.nextInt(), sc.nextInt()));
        }

        list.sort(new PieceComparator());

        float benefit = 0;
        List<Piece> solution = new ArrayList<>();

        while(maxW>0){
            Piece p = list.remove(0);
            if(maxW-p.weight >=0){
                maxW -= p.weight;
                benefit += p.defense;
                solution.add(p);
            }else{
                float aux = maxW/p.weight;
                benefit = benefit + (aux*p.defense);
                maxW = 0;
                solution.add(p);
            }
        }

        solution.sort(new NameComparator());

        System.out.println(roundOffTo2DecPlaces(benefit));
        for(Piece p : solution){
            System.out.println(p.name);
        }



    }
    private static String roundOffTo2DecPlaces(float val) {

        return String.format("%.2f", val);

    }

    private static class Piece{
        String name;
        int weight;
        int defense;
        float ratio;

        public Piece(String name, int weight, int defense) {
            this.name = name;
            this.weight = weight;
            this.defense = defense;
            this.ratio = (float)defense/weight;
        }
    }

    private static class PieceComparator implements Comparator<Piece>{

        @Override
        public int compare(Piece o1, Piece o2) {
            if(o1.ratio>o2.ratio){
                return -1;
            }else if(o1.ratio==o2.ratio){
                return 0;
            }else{
                return 1;
            }
        }
    }

    private static class NameComparator implements Comparator<Piece>{

        @Override
        public int compare(Piece o1, Piece o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}
