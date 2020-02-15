package com.company;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


public class output {

    public void output(ArrayList<int> results, int noOfSlices ) {


        lineOne = result.size();

        lineTwo = "";
        for (int num : results) {
            lineTwo += num;
            lineTwo += " ";
        }

        lineTwo -= " ";

        System.out.println(lineOne);
        System.out.println(lineTwo);

//        Create file

        try {
            File myObj = new File("submission.out");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


//      Write tio file.

        try {
            FileWriter myWriter = new FileWriter("submission.out");
//            myWriter.write(lineOne);
//            myWriter.write(lineTwo);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
