import java.util.ArrayList;
// import Input.Input;

public class Main {

    public static void main(String[] args) {
	    Input input = new Input();
	    input.readTextFile();
        ArrayList<Integer> result = DummyAlgo2.computeOutput(input.getMaxSlices(), input.getNoPizzaSlices());

    }
}
