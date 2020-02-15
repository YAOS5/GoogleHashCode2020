import java.util.ArrayList;
import java.util.Collections;

public class DummyAlgo2 {
    public static ArrayList<Integer> computeOutput(int M, int[] pizzas) {
        int total = 0;
        ArrayList<Integer> output = new ArrayList<>();
        int i = pizzas.length - 1;
        for (; i >= 0; i--) {
            if (total + pizzas[i] <= M) {
                total += pizzas[i];
                output.add(i);
            }
        }

        for (int j = 0; j <= i; j++) {
            if (total + pizzas[j] <= M) {
                total += pizzas[j];
                output.add(j);
            }
        }

        Collections.reverse(output);


        return output;
    }
}
