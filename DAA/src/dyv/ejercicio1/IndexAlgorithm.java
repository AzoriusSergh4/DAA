package dyv.ejercicio1;

public class IndexAlgorithm {

    public int resolve(int[] list, int firstIndex){
        int resul = -1;
        if(list.length ==1){
            if(list[0] == firstIndex){
                return list[0];
            }else return -1;
        }
        int[] left;
        int[] right;
        int half = list.length/2;
        left = new int[half];
        if(list.length %2 == 0){
            right = new int[half];
        }else{
            right = new int[half+1];
        }


        for(int i=0; i<left.length; i++){
            left[i] = list[i];
        }
        for(int i=0; i<right.length; i++){
            right[i] = list[half+i];
        }
        int leftSol;
        int rightSol;

        int mediumIndex = firstIndex+half;

        leftSol = resolve(left, firstIndex);
        rightSol = resolve(right, mediumIndex);

        if(leftSol != -1){
            resul = leftSol;
            return resul;
        }
        if (rightSol != -1) {
            resul = rightSol;
            return resul;
        }

        return resul;
    }
}
