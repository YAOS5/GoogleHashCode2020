import java.util.ArrayList;
import java.util.Collections;

public class DummyAlgo2 {
    public static ArrayList<Integer> computeOutput(int M, ArrayList<Integer> pizzas) {
        int total = 0;
        ArrayList<Integer> output = new ArrayList<>();
        int i = pizzas.size() - 1;
        for (; i >= 0; i--) {
            if (total + pizzas.get(i) <= M) {
                total += pizzas.get(i);
                output.add(i);
            }
        }

        for (int j = 0; j <= i; j++) {
            if (total + pizzas.get(j) <= M) {
                total += pizzas.get(j);
                output.add(j);
            }
        }

        Collections.reverse(output);


        return output;
    }
}
