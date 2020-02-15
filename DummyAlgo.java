import java.util.ArrayList;

public class DummyAlgo {

    public static ArrayList<Integer> computeOutput(int M, int[] pizzas) {
        int total = 0;
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < pizzas.length; i++) {
            if (total + pizzas[i] <= M) {
                total += pizzas[i];
                output.add(i);
            }
        }

        return output;
    }


    public static void main(String[] args) {

    }
}
