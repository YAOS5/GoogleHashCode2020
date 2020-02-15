package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Input input = new Input();
	    input.readTextFiles();
        ArrayList<Integer> result = DummyAlgo2(input.getMaxPizzaSlices, input.getNoPizzaSlices);

        output.Tofile(result);
    }
}
