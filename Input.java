package com.company;

import java.io.File;  // Import the File class
import java.util.*;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.stream.Collectors;

public class Input {

    ArrayList <String> slices;
    String maxSlices;

    public void readTextFile() {
      try {
        Scanner sc = null;
        sc = new Scanner(new File("/Users/shivam/Documents/GitHub/GoogleHashCode20/src/com/company/data/b_small.in"));
        String line1 = sc.nextLine();
        String[] words1 = line1.split(" ");
        String line2 = sc.nextLine();
        String[] words2 = line2.split(" ");
        maxSlices = words1[0];
        slices = new ArrayList<String>(Arrays.asList(words2));
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }

    }


    public ArrayList<Integer> getNoPizzaSlices() {
      return slices.stream().map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getMaxSlices() {
      return Integer.valueOf(maxSlices);
    }

}
