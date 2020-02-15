//package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java. util. Iterator;


public class DummyAlgo3 {

    public static ArrayList<Integer> computeOutput(int max_slices, ArrayList<Integer> pizzas) {

      HashSet<Pizza> pizzaSet = new HashSet();

      for(int i=0; i<pizzas.size(); i++) {
        Pizza pizza = new Pizza(i, pizzas.get(i));
        pizzaSet.add(pizza);
      }

      return K(max_slices, pizzaSet);
    }

    public HashSet<Pizza> K(int max_slices, HashSet<Pizza> pizzas) {

      ArrayList<Integer> k_list = new ArrayList<>();

      Iterator<Pizza> itr = pizzas.iterator();

      while(itr.hasNext()) {

        Pizza pizza = itr.next();
        HashSet<Pizza> reduced_set = new HashSet();

        reduced_set = (HashSet)pizzas.clone();
        reduced_set.remove(pizza);

        k_list.add(pizza.slices + K(max_slices-pizza.slices, reduced_set));
      }



      return Collections.max(k_list);
      // return k_list.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
      // int m = 0;
      // for (i: k_list) {
      //   if (i > m) {
      //     m = i;
      //   }
      // }
    }

}
