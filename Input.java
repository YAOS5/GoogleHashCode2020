package com.company;

import java.io.File;  // Import the File class
import java.util.*;
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Input {

    ArrayList <Integer> slices = new ArrayList<Integer>();
    int maxSlices;

    public void readTextFile() thows FileNotFoundException {
      FileReader inputStream = null;
      try {
        inputStream = new FileReader("c_medium.txt");
        int c;
      while((c = inputStream.read()) != -1) {
        if(flag == 2) break;
        if()
      }
      myReader.close();
      }
    }

    public ArrayList<Integer> getNoPizzaSlices() {
      return slices;
    }

    public int getMaxSlices() {
      return maxSlices;
    }

}
