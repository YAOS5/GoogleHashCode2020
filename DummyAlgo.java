import java.util.ArrayList;

public class DummyAlgo {

    public static ArrayList<Integer> computeOutput(int M, ArrayList<Integer> pizzas) {
        int total = 0;
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < pizzas.size(); i++) {
            if (total + pizzas.get(i) <= M) {
                total += pizzas.get(i);
                output.add(i);
            }
        }

        return output;
    }

}
