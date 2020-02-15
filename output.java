import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList; // import the ArrayList class
import java.io.FileWriter;   // Import the FileWriter class

public class output {

//     public static void main(String[] args) {
//         ArrayList<Integer> list=new ArrayList<Integer>();
//         list.add(1);
//         list.add(5);
//         outputToFile(list);
//     }

    public static void outputToFile(ArrayList<Integer> results ) {


        String lineOne = String.valueOf(results.size());
        lineOne += "\n";

        String lineTwo = "";
        for (int num : results) {
            lineTwo += num;
            lineTwo += " ";
        }
        lineTwo = lineTwo.substring(0, lineTwo.length() - 1);


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


//      Write to file.
        try {
            FileWriter myWriter = new FileWriter("submission.out");
            myWriter.write(lineOne);
            myWriter.write(lineTwo);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
