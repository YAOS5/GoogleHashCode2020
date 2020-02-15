package com.company;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DummyAlgoTest {
    int M = 10;
    int[] pizzas = new int[]{2, 3, 7};


    @org.junit.jupiter.api.Test
    void computeOutput() {
        ArrayList result = DummyAlgo.computeOutput(M, pizzas);
        System.out.println(result);
    }


    @org.junit.jupiter.api.Test
    void computeOutput2() {
        ArrayList result = DummyAlgo2.computeOutput(M, pizzas);
        System.out.println(result);

    }
}